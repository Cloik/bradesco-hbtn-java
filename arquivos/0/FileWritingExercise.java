import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite linhas de texto. Para encerrar, digite 'sair'.");

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.write(line);
                writer.newLine(); // Adiciona quebra de linha
            }

            System.out.println("Arquivo '" + fileName + "' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
