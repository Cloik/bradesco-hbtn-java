package estruturas_de_dados;

import java.util.Scanner;

public class ArrayExercicio {
    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;

        // Preenchendo o array com números fornecidos pelo usuário
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i+1) + ": ");
            int numeroInformado = scanner.nextInt();
            numeros[i] = numeroInformado;
        }

        // Exibindo os resultados
        System.out.println("\n\nConteúdo do array:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
            soma += numeros[i];
        }
        System.out.println("\nSoma de todos os números: " + soma);

        int maior = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] > maior){
                maior = numeros[i];
            }
        }
        System.out.print("Maior número no array: " + maior);

        // Fechando o scanner
        scanner.close();
    }
}
