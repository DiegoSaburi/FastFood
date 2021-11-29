package FastFood;

public class Gerente extends Funcionario {
    /**
     * Retorna um objeto da classe Gerente, contém agregação forte com restaurante
     * @param nomeGerente
     */
    public Gerente(String nomeGerente){
        super(nomeGerente, 0.05);

    }

    /**
     * Retorna a bonificação em valores brutos do Gerente
     * @return bonificação total do gerente
     */
    public double bonificacaoTotal() {
        return Restaurante.getMontante()*getPercentualBonificacao();
    }

    /**
     * seta a bonificação total do gerente de acordo com a regra de negócio da classe
     * @implNote não sobrescreve da classe mãe, que servirá para setar valor específico sem seguir regra de negócio
     */
    public void setBonificacaoTotal() {
        super.setBonificacaoTotal(bonificacaoTotal());
    }

    /**
     * Retorna a bonificação total do gerente
     * @return bonificação total em valor bruto
     */
    @Override
    public double getBonificacaoTotal() {
        return bonificacaoTotal();
    }
}
