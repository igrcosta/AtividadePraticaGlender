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