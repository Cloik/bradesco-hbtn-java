package estruturas_de_dados;

import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
     private final List<Aluno> listAlunos = new ArrayList<>();

     public void adicionarAluno(String nome, int idade){
        listAlunos.add(new Aluno(nome,idade));
         System.out.println("Aluno adicionado: " + nome);
     }

    public void excluirAluno(String nome) {
        Aluno alunoParaRemover = null;

        for (Aluno aluno : listAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunoParaRemover = aluno;
                break; // Remove apenas o primeiro encontrado
            }
        }

        if (alunoParaRemover != null) {
            listAlunos.remove(alunoParaRemover);
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        boolean encontrado = false;

        for (Aluno aluno : listAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void listarAlunos() {
        if (listAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de alunos:");
            for (Aluno aluno : listAlunos) {
                System.out.println(aluno);
            }
        }
    }

}
