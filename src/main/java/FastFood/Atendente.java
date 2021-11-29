package FastFood;

public class Atendente extends Funcionario{
    /**
     * Retorna um objeto da classe Atendente, contém ligação forte
     * com a classe Guiche
     * @param nome - nome do atendente
     */
    public Atendente(String nome){
        super(nome, 0.15);
    }

    /**
     * Retorna o nome do funcionário
     * @return nome do funcionário
     */
    @Override
    public String toString() {
        return super.getNome();
    }
}
