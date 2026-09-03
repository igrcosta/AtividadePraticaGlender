import java.time.LocalDate;

public class Aluno {
    private String nome;
    private int idade;
    private double coragem;
    private double inteligencia;
    private double ambicao;
    private double lealdade;
    private double estrategia;
    private double criatividade;
    private String casa;

    //coisas da 2a parte
    private LocalDate data_nascimento;
    private String codigoMatricula;
    private boolean Maioridade = false;

    public Aluno(String nome, int idade, double coragem, double inteligencia, double ambicao, double lealdade, double estrategia, double criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "Não Selecionado";
    }

    public void calcularCasa() {
        double ptGrifinoria = (2 * this.coragem) + this.lealdade;
        double ptSonserina = (2 * this.ambicao) + this.estrategia;
        double ptCorvinal = (2 * this.inteligencia) + this.criatividade;
        double ptLufaLufa = ((2 * this.lealdade) + this.coragem) / 3.0;

        double maiorPontuacao = ptGrifinoria;
        this.casa = "Grifinória";

        if (ptSonserina > maiorPontuacao) {
            maiorPontuacao = ptSonserina;
            this.casa = "Sonserina";
        }
        if (ptCorvinal > maiorPontuacao) {
            maiorPontuacao = ptCorvinal;
            this.casa = "Corvinal";
        }
        if (ptLufaLufa > maiorPontuacao) {
            maiorPontuacao = ptLufaLufa;
            this.casa = "Lufa-Lufa";
        }
    }

    //segunda parte -> INÍCIO

    private LocalDate anoAtual = LocalDate.now();

    public void calcularIdade(){
        setIdade(anoAtual.getYear() - data_nascimento.getYear());
        //isso vai me retornar a idade aproximada e jogar dentro da idade do aluno
    }

    public void verificarMaioridade(){
        if (getIdade() >= 17)
        {
            Maioridade = true;
        }
        else{
            Maioridade = false;
        }
    }

    public void reformatarCasa(){
        //tenho que pegar a string do nome e converter ela
        if (nome != null)
        {
            setNome(nome.toUpperCase());
        }
    }

    public void gerarUsername(){
        //precisa ser primeira letra do nome + sobrenome completo minúsculo

        String primeiraLetra = getNome().substring(0,1);
        //substring é literalmente eliminar tudo da string e deixar só o que você seleciona com begin e end Index

        //agora vou precisar pegar o nome e separar em palavras, pra aí sim, eu pegar a 2a palavra, conhecida como sobrenome de onde eu venho

        String[] palavras = getNome().split(" ");
        //com esse espaço em branco, separamos o nome em arrays de strings, se o cara botar o nome completo sem espaço, aí ferrou

        if (palavras > 1)
        {

        }


    }
    //segunda parte -> FIM

    public void exibirInformacoes() {
        System.out.println("====================================");
        System.out.println("          FICHA DO ALUNO            ");
        System.out.println("====================================");
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
        System.out.println("Coragem: " + this.coragem);
        System.out.println("Inteligência: " + this.inteligencia);
        System.out.println("Ambição: " + this.ambicao);
        System.out.println("Lealdade: " + this.lealdade);
        System.out.println("Estratégia: " + this.estrategia);
        System.out.println("Criatividade: " + this.criatividade);
        System.out.println("------------------------------------");
        System.out.println("Casa Escolhida: " + this.casa);
        System.out.println("====================================\n");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public double getCoragem() { return coragem; }
    public void setCoragem(double coragem) { this.coragem = coragem; }

    public double getInteligencia() { return inteligencia; }
    public void setInteligencia(double inteligencia) { this.inteligencia = inteligencia; }

    public double getAmbicao() { return ambicao; }
    public void setAmbicao(double ambicao) { this.ambicao = ambicao; }

    public double getLealdade() { return lealdade; }
    public void setLealdade(double lealdade) { this.lealdade = lealdade; }

    public double getEstrategia() { return estrategia; }
    public void setEstrategia(double estrategia) { this.estrategia = estrategia; }

    public double getCriatividade() { return criatividade; }
    public void setCriatividade(double criatividade) { this.criatividade = criatividade; }

    public String getCasa() { return casa; }
}