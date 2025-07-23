import produtos.Livro;

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
        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto() instanceof Livro ? "Livro" : "Dvd";
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = preco * quantidade;

            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo,
                    titulo,
                    preco,
                    quantidade,
                    totalItem);
        }

        System.out.println("----------------------------");

        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - valorDesconto;

        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
}
