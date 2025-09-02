
import java.util.ArrayList;
import java.util.List;

public class ListaTodo {
    private final List<Tarefa> tarefas;

    public ListaTodo() {
        tarefas = new ArrayList<Tarefa>();
    }

    public void adicionarTarefa(Tarefa novaTarefa){
        for(Tarefa t :  tarefas){
            if(t.getIdentificador() == novaTarefa.getIdentificador()){
                throw new IllegalArgumentException("Tarefa com identificador " + novaTarefa.getIdentificador() + " ja existente na lista");
            }
        }
        tarefas.add(novaTarefa);
    }

    public boolean marcarTarefaFeita (int identificador){
        for(Tarefa t : tarefas){
            if(t.getIdentificador() == identificador){
                t.marcarFeita();
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa (int identificador){
        for(Tarefa t : tarefas){
            if(t.getIdentificador() == identificador){
                t.desfazer();
                return true;
            }
        }
        return false;
    }

    public void fazerTodas (){
        for (Tarefa t : tarefas) {
            t.desfazer();
        }
    }

    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.desfazer();
        }
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String status = t.isEstahFeita() ? "[X]" : "[ ]";
            System.out.println(status + "  Id: " + t.getIdentificador() + " - Descricao: " + t.getDescricao());
        }
    }
}
