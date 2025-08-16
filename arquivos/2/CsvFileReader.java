
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String arquivo = "funcionario.csv";
        String linha;

        try(BufferedReader buffer = new BufferedReader(new FileReader(arquivo))){

            while((linha = buffer.readLine()) != null){
                if(linha.trim().isEmpty()){ //Ignora as linhas em branco
                    continue;
                }
                String[] dados = linha.split(",");
                if(dados.length == 4){
                    System.out.println("Funcionário: " + dados[0]);
                    System.out.println("Idade: " + dados[1]);
                    System.out.println("Departamento: " + dados[2]);
                    System.out.println("Salarial: " + dados[3]);
                    System.out.println("------------------------");
                }
            }
            System.out.println("Leitura do arquivo concluída.");
        }catch (IOException e){
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
