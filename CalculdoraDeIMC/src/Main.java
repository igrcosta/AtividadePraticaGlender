import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double IMCCalculado = 0;

        System.out.println("Vamos ver seu IMC e se tu tá gordo!");
        System.out.println("Qual seu nome?");
        String nomeInserido = entrada.nextLine();

        System.out.println("E seu sobrenome?");
        String sobrenomeInserido = entrada.nextLine();

        System.out.println("Ok " + nomeInserido + " " + sobrenomeInserido + "!\nAgora sua idade:");
        int idadeInserida = entrada.nextInt();

        System.out.println("Sua altura:");
        double alturaInserida = entrada.nextDouble();

        System.out.println("Seu Peso:");
        double pesoInserido = entrada.nextDouble();

        Pessoa usuario = new Pessoa(nomeInserido, sobrenomeInserido, idadeInserida, alturaInserida, pesoInserido, 0);
        //por enquanto IMC é 0. Mas já temos o usuário instanciado

        IMCCalculado = usuario.CalculaIMC();
        //agora o IMC tá guardado numa variavel

        usuario.setIMC(IMCCalculado);
        //agora dentro do objeto já tem seu próprio IMC

        System.out.println("IMC Calculado! Veja seus resultados:");
        System.out.println("Seu IMC: " + usuario.getIMC());
        System.out.println("Resultados:");
        usuario.InformaObesidade();

        System.out.println("Agora tchau! vai treinar!");
    }
}