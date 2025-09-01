
import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero){
        int posicao = -1;

        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i).equals(numero)){
                posicao = i;
            }
        }
        return posicao;
    }

    static void adicionarNumero(List<Integer>listaNumeros, int numero){

        if(buscarPosicaoNumero(listaNumeros,numero) == -1){
            listaNumeros.add(numero);
        }else{
            throw new RuntimeException("Numero jah contido na lista");
        }
    }

    static void removerNumero (List<Integer>listaNumeros, int numero){
        int posicao = buscarPosicaoNumero(listaNumeros,numero);

        if(posicao == -1){
            throw new RuntimeException("Numero nao encontrado na lista");
        }else{
            listaNumeros.remove(posicao);
        }
    }

    static void substituirNumero(List<Integer>listaNumeros, int numeroSubstituir, int numeroSubstituto){
        int posicao = buscarPosicaoNumero(listaNumeros,numeroSubstituir);

        if(posicao == -1){
            adicionarNumero(listaNumeros,numeroSubstituto);
        }else{
            listaNumeros.set(posicao,numeroSubstituto);
        }
    }
}
