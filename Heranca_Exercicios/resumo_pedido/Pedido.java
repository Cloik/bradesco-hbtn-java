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

    public double calcularTotal() {
        BigDecimal totalProdutos = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            BigDecimal preco = BigDecimal.valueOf(item.getProduto().obterPrecoLiquido())
                    .setScale(2, RoundingMode.DOWN);

            BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
            BigDecimal totalItem = preco.multiply(quantidade)
                    .setScale(2, RoundingMode.DOWN);

            totalProdutos = totalProdutos.add(totalItem).setScale(2, RoundingMode.DOWN);
        }

        BigDecimal taxaDesconto = BigDecimal.valueOf(percentualDesconto)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.DOWN);

        BigDecimal desconto = totalProdutos.multiply(taxaDesconto)
                .setScale(2, RoundingMode.DOWN);

        BigDecimal totalFinal = totalProdutos.subtract(desconto)
                .setScale(2, RoundingMode.DOWN);

        return totalFinal.doubleValue();
    }

    public void apresentarResumoPedido() {
        Locale.setDefault(new Locale("pt", "BR"));
        NumberFormat formato = NumberFormat.getNumberInstance(Locale.getDefault());
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        formato.setRoundingMode(RoundingMode.DOWN);

        System.out.println("------- RESUMO PEDIDO -------");

        BigDecimal totalProdutos = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto() instanceof Livro ? "Livro" : "Dvd";
            String titulo = item.getProduto().getTitulo();

            BigDecimal precoUnitario = BigDecimal.valueOf(item.getProduto().obterPrecoLiquido())
                    .setScale(2, RoundingMode.HALF_UP);

            BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
            BigDecimal totalItem = precoUnitario.multiply(quantidade)
                    .setScale(2, RoundingMode.HALF_UP);

            totalProdutos = totalProdutos.add(totalItem).setScale(2, RoundingMode.HALF_UP);

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %s  Quant: %d  Total: %s\n",
                    tipo,
                    titulo,
                    formato.format(precoUnitario.doubleValue()),
                    item.getQuantidade(),
                    formato.format(totalItem.doubleValue()));
        }

        System.out.println("----------------------------");

        BigDecimal taxaDesconto = BigDecimal.valueOf(percentualDesconto)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);

        BigDecimal desconto = totalProdutos.multiply(taxaDesconto)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalPedido = totalProdutos.subtract(desconto)
                .setScale(2, RoundingMode.HALF_UP);

        System.out.println("DESCONTO: " + formato.format(desconto.doubleValue()));
        System.out.println("TOTAL PRODUTOS: " + formato.format(totalProdutos.doubleValue()));
        System.out.println("----------------------------");
        System.out.println("TOTAL PEDIDO: " + formato.format(totalPedido.doubleValue()));
        System.out.println("----------------------------");
    }


}
