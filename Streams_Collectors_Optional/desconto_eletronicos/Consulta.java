
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> {
                    if (p.getCategoria() == CategoriaProduto.ELETRONICO) {
                        Produto produtoComDesconto = new Produto(
                                p.getCodigo(),
                                p.getNome(),
                                p.getCategoria(),
                                p.getPreco() * 0.85
                        );
                        return produtoComDesconto;
                    } else {
                        return p;
                    }
                })
                .collect(Collectors.toList());
    }
}




