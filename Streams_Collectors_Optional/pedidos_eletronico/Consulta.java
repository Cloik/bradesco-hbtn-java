
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(p -> p.getProdutos().stream()
                        .anyMatch(prod -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
                .collect(Collectors.toList());
    }
}



