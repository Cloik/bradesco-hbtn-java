
public class ArmazemDeEletronico extends Armazem<Eletronico>{

    @Override
    public void adicionarAoInventario(String nome, Eletronico valor) {
        inventario.put(nome, valor);
    }

    @Override
    public Eletronico obterDoInventario(String nome) {
        return inventario.get(nome);
    }
}
