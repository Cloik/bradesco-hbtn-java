
public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Autor)) return false;
        Autor outro = (Autor) obj;
        return nome.equals(outro.nome) && sobrenome.equals(outro.sobrenome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + sobrenome.hashCode();
    }

    @Override
    public int compareTo(Autor outro) {
        return this.toString().compareTo(outro.toString());
    }
}

