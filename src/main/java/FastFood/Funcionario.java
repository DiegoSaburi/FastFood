package FastFood;

public abstract class Funcionario {
    private String nome;
    private double bonificacaoTotal;
    private final double percentualBonificacao;

    /**
     * Classe abstrata de funcionario do restaurante
     * @param nome - nome do funcionario
     */
    public Funcionario(String nome, double percentualBonificacao){
    this.nome =  nome;
    this.bonificacaoTotal = 0;
    this.percentualBonificacao = percentualBonificacao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", bonificacaoTotal=" + bonificacaoTotal +
                '}';
    }

    /**
     * Retorna o percentual de bonificação do funcionário
     * @return percentual de bonificação do funcionário
     */
    public double getPercentualBonificacao() {
        return percentualBonificacao;
    }

    /**
     * Adiciona à bonificação total o valor referente ao bonus que o funcionário recebe pela venda
     * @param valor - valor da venda
     */
    public void addBonificacao(double valor) {
        this.bonificacaoTotal += valor;
    }

    /**
     * Seta a bonificação total do funcionário
     * @param bonificacaoTotal - bonificação total do funcionário
     */
    public void setBonificacaoTotal(double bonificacaoTotal) {
        this.bonificacaoTotal = bonificacaoTotal;
    }

    /**
     *  retorna a bonificação do funcionario
     * @return bonificação em valores brutos
     */
    public double getBonificacaoTotal() {
        return bonificacaoTotal;
    }

    /**
     * Seta o nome do funcionario
     * @param nome - nome do funcionario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome do funcionario
     * @return nome do funcionario
     */
    public String getNome() {
        return nome;
    }


}
