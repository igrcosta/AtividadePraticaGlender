public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double IMC;

    //construtor de parâmetros
    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso, double IMC)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.IMC = IMC;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double CalculaIMC()
    {
        //peso pela altura ao quadrado
        IMC = getPeso() / Math.pow(getAltura(), 2);
        return IMC;
    }

    public void InformaObesidade()
    {
        //logica da tabela de IMC
        if (getIMC() >= 40)
        {
            System.out.println("Obesidade grau 3");
        }
        else if (getIMC() <= 39.9 && getIMC() >= 35)
        {
            System.out.println("Obesidade grau 2");
        }
        else if (getIMC() <= 34.9 && getIMC() >= 30)
        {
            System.out.println("Obesidade grau 1");
        }
        else if (getIMC() <= 29.9 && getIMC() >= 25)
        {
            System.out.println("sobrepeso");
        }
        else if (getIMC() <= 24.9 && getIMC() >= 18.5)
        {
            System.out.println("Peso normal");
        }
        else if (getIMC() <= 18.5)
        {
            System.out.println("Abaixo do peso");
        }
    }
}
