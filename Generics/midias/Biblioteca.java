
import java.util.ArrayList;
import java.util.List;

public class Biblioteca <T> {

    List<T> listaBiblioteca = new ArrayList<>();

    public void adicionarMidia(T value){
        listaBiblioteca.add(value);
    }

    public List<T> obterListaMidias(){
        return listaBiblioteca;
    }
}
