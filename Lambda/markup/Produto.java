
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10.0;

    public Supplier<Double> precoComMarkup;
    public Consumer<Double> atualizarMarkup;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;

        // Lambda que calcula o preço com markup
        precoComMarkup = () -> preco + (preco * percentualMarkup / 100);

        // Lambda que atualiza o percentual de markup
        atualizarMarkup = novoMarkup -> this.percentualMarkup = novoMarkup;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

