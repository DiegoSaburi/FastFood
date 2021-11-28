package FastFood;

public class Gerente extends Funcionario {
    public Gerente(String nomeGerente){
        super(nomeGerente, 0.05);
    }

    public double bonificacaoTotal() {
        return Restaurante.getMontante()*getPercentualBonificacao();
    }
}
