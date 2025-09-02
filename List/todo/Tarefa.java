
public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        if(descricao == null || descricao.trim().isEmpty()){
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
        this.identificador = identificador;
        this.estahFeita = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void modificarDescricao(String descricao){
        if(descricao.trim().isEmpty() || descricao == null){
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }else{
            this.descricao = descricao;
        }
    }

    public void marcarFeita() {
        this.estahFeita = true;
    }

    public void desfazer() {
        this.estahFeita = false;
    }
}
