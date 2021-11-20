package FastFood;

public class Gerente extends Funcionario {
    private String setorResponsavel;
    public Gerente(String setorReponsavel, String nome, double salarioBase, double valorHora, double horasExtras, double bonificacao){
        super(nome, salarioBase, valorHora, horasExtras, bonificacao);
        this.setorResponsavel = setorReponsavel;

    }
}
