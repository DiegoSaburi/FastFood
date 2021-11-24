package FastFood;

public abstract class Funcionario {
    private String nome;
    private double salarioBase;
    private double valorHora;
    private double horasExtras;
    private double bonificacao;

    public Funcionario(String nome, double salarioBase, double valorHora, double horasExtras, double bonificacao){
    this.nome =  nome;
    this.salarioBase = salarioBase;
    this.valorHora = valorHora;
    this.horasExtras = horasExtras;
    this.bonificacao = bonificacao;
    }

    public void setBonificacao(double bonificacao){
        this.bonificacao = bonificacao;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getValorHora() {
        return valorHora;
    }

    public String getNome() {
        return nome;
    }
}
