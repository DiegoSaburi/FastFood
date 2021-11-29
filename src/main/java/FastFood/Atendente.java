package FastFood;

public class Atendente extends Funcionario{
    public Atendente(String nome){
        super(nome, 0.15);
    }

    @Override
    public String toString() {
        return super.getNome();
    }
}
