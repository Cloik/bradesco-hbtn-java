
public class ArmazemDeComida extends Armazem<Comida>{

    @Override
    public void adicionarAoInventario(String nome, Comida valor) {
        inventario.put(nome, valor);
    }

    @Override
    public Comida obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}
