
import produtos.Livro;

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
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        formato.setMinimumFractionDigits(2);
        formato.setMaximumFractionDigits(2);
        formato.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto() instanceof Livro ? "Livro" : "Dvd";
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;

            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %s  Quant: %d  Total: %s\n",
                    tipo,
                    titulo,
                    formato.format(preco),
                    quantidade,
                    formato.format(totalItem));
        }

        System.out.println("----------------------------");

        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - valorDesconto;

        System.out.println("DESCONTO: " + formato.format(valorDesconto));
        System.out.println("TOTAL PRODUTOS: " + formato.format(totalProdutos));
        System.out.println("----------------------------");
        System.out.println("TOTAL PEDIDO: " + formato.format(totalPedido));
        System.out.println("----------------------------");
    }
}
