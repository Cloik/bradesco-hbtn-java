
import java.util.LinkedList;

public class Fila {
    private final LinkedList<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // espera espaço na fila
        }
        fila.add(item);
        System.out.println("Produtor adicionou: " + item);
        notifyAll(); // notifica consumidores
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // espera item na fila
        }
        int item = fila.removeFirst();
        System.out.println("Consumidor retirou: " + item);
        notifyAll(); // notifica produtores
        return item;
    }
}

