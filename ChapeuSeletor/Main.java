import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        System.out.println("============================================");
        System.out.println("  BEM-VINDO À SELEÇÃO DE CASAS DE HOGWARTS  ");
        System.out.println("============================================");

        while (!opcao.equalsIgnoreCase("N")) {
            System.out.println("\n--- Digite os dados do novo aluno ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            System.out.print("Pontuação de Coragem: ");
            double coragem = Double.parseDouble(scanner.nextLine());

            System.out.print("Pontuação de Inteligência: ");
            double inteligencia = Double.parseDouble(scanner.nextLine());

            System.out.print("Pontuação de Ambição: ");
            double ambicao = Double.parseDouble(scanner.nextLine());

            System.out.print("Pontuação de Lealdade: ");
            double lealdade = Double.parseDouble(scanner.nextLine());

            System.out.print("Pontuação de Estratégia: ");
            double estrategia = Double.parseDouble(scanner.nextLine());

            System.out.print("Pontuação de Criatividade: ");
            double criatividade = Double.parseDouble(scanner.nextLine());

            // Instância do Aluno
            Aluno aluno = new Aluno(nome, idade, coragem, inteligencia, ambicao, lealdade, estrategia, criatividade);

            // Processamento da seleção
            aluno.calcularCasa();

            // Exibição dos resultados
            aluno.exibirInformacoes();

            System.out.print("Deseja cadastrar outro aluno? (S/N): ");
            opcao = scanner.nextLine();
        }

        System.out.println("\nO Chapéu Seletor cansou de decidir o destino dos outros, SAI FORA!");
        scanner.close();
    }
}