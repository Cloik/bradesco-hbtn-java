
public class PersonagemGame {

    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeAtual, String nome) {
        setSaudeAtual(saudeAtual);
        this.nome = nome;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            saudeAtual = 0;
        } else if (saudeAtual > 100) {
            saudeAtual = 100;
        }

        this.saudeAtual = saudeAtual;
        this.status = (this.saudeAtual > 0) ? "vivo" : "morto";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && nome != ""){
            this.nome = nome;
        }
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano){
        setSaudeAtual(saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura){
        setSaudeAtual(saudeAtual + quantidadeDeCura);
    }
}
