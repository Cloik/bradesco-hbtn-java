
public class Buffer {
    private int item = -1; // -1 indica que o buffer está vazio

    public synchronized void produzir(int item) throws InterruptedException {
        while (this.item != -1) {
            wait(); // Espera o consumidor consumir o item
        }
        this.item = item;
        System.out.println("Produtor produziu: " + item);
        notify(); // Notifica o consumidor
    }

    public synchronized int consumir() throws InterruptedException {
        while (this.item == -1) {
            wait(); // Espera o produtor produzir um item
        }
        int consumido = this.item;
        this.item = -1; // Indica que o buffer está vazio
        System.out.println("Consumidor consumiu: " + consumido);
        notify(); // Notifica o produtor
        return consumido;
    }
}
