import provedores.Frete;

public class Pedido {
    private int codigo;
    private double peso;
    private double total;
    private Frete frete;

    public Pedido(int codigo, double peso, double total) {
        this.codigo = codigo;
        this.peso = peso;
        this.total = total;
    }

    public double getPeso() {
        return peso;
    }

    public double getTotal() {
        return total;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Frete getFrete() {
        return frete;
    }
}

