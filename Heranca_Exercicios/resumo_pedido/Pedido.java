import produtos.Livro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public double calcularTotal(){
        double total = 0.0;
        for(ItemPedido item : itens){
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        total -= total * (percentualDesconto / 100.0);
        return total;
    }

    public void apresentarResumoPedido() {
        Locale.setDefault(new Locale("pt", "BR"));
        NumberFormat formato = NumberFormat.getNumberInstance(Locale.getDefault());
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        formato.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("------- RESUMO PEDIDO -------");
        BigDecimal totalProdutos = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto() instanceof Livro ? "Livro" : "Dvd";
            String titulo = item.getProduto().getTitulo();

            BigDecimal preco = BigDecimal.valueOf(item.getProduto().obterPrecoLiquido())
                    .setScale(2, RoundingMode.HALF_UP);

            int quantidade = item.getQuantidade();

            BigDecimal totalItem = preco.multiply(BigDecimal.valueOf(quantidade))
                    .setScale(2, RoundingMode.HALF_UP);

            totalProdutos = totalProdutos.add(totalItem);

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %s  Quant: %d  Total: %s\n",
                    tipo,
                    titulo,
                    formato.format(preco.doubleValue()),
                    quantidade,
                    formato.format(totalItem.doubleValue()));
        }

        System.out.println("----------------------------");

        BigDecimal valorDesconto = totalProdutos
                .multiply(BigDecimal.valueOf(percentualDesconto).divide(BigDecimal.valueOf(100)))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalPedido = totalProdutos.subtract(valorDesconto)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("DESCONTO: " + formato.format(valorDesconto.doubleValue()));
        System.out.println("TOTAL PRODUTOS: " + formato.format(totalProdutos.doubleValue()));
        System.out.println("----------------------------");
        System.out.println("TOTAL PEDIDO: " + formato.format(totalPedido.doubleValue()));
        System.out.println("----------------------------");
    }

}
