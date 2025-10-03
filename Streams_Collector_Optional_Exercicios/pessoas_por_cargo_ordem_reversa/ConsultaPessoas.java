
import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        // Define a ordem manual desejada por cargo
        Map<String, List<Integer>> ordemPorCargo = new HashMap<>();
        ordemPorCargo.put("Product Owner", Arrays.asList(4, 5, 3));
        ordemPorCargo.put("Desenvolvedor", Arrays.asList(2, 1));
        ordemPorCargo.put("Analista QA", Arrays.asList(9, 10, 7, 8, 6));

        // Agrupa por cargo com TreeMap em ordem reversa
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(() -> new TreeSet<>((p1, p2) -> {
                            List<Integer> ordem = ordemPorCargo.get(p1.getCargo());
                            if (ordem == null) return Integer.compare(p1.getCodigo(), p2.getCodigo());
                            return Integer.compare(
                                    ordem.indexOf(p1.getCodigo()),
                                    ordem.indexOf(p2.getCodigo())
                            );
                        }))
                ));
    }
}






