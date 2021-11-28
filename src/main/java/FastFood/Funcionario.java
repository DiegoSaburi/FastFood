package FastFood;

public abstract class Funcionario {
    private String nome;
    private double percentualBonificacao;
    private double bonificacaoTotal;

    public Funcionario(String nome, double percentualBonificacao){
    this.nome =  nome;
    this.percentualBonificacao = percentualBonificacao;
    this.bonificacaoTotal = 0;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", bonificacaoTotal=" + bonificacaoTotal +
                '}';
    }

    public double getBonificacaoTotal() {
        return bonificacaoTotal;
    }

    public void addBonificacao(double valor) {
        this.bonificacaoTotal += valor*percentualBonificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPercentualBonificacao() {
        return percentualBonificacao;
    }

    public void setPercentualBonificacao(double percentualBonificacao) {
        this.percentualBonificacao = percentualBonificacao;
    }
}
