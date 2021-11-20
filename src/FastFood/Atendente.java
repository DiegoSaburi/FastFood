package FastFood;

public class Atendente extends Funcionario{
    private Guiche guicheResponsavel;
    public Atendente(Guiche guicheReponsavel, String nome, double salarioBase, double valorHora, double horasExtras, double bonificacao){
        super(nome, salarioBase, valorHora, horasExtras, bonificacao);
        this.guicheResponsavel = guicheReponsavel;

    }
    public void setBonificacao(double bonificacao){
        super.setBonificacao(bonificacao);
    }
    public double calculaSalarioTotal(){
       return super.getSalarioBase() + (super.getValorHora() * super.getHorasExtras()) + super.getBonificacao();
    }
}
