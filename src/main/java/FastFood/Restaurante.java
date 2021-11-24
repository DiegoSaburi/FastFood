package FastFood;
import java.util.ArrayList;
import java.util.Collections;

public class Restaurante {
    public String nome;
    public ArrayList<Guiche> guiches;
    private String cnpj;

	public Restaurante(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.guiches = new ArrayList<>();
	}

    public double montanteTotal(){
        double montante = 0;
        for (Guiche guiche : guiches){
            montante += guiche.getMontante();
        }
        return montante;
    }

    public void addGuiche(){
        this.guiches.add(new Guiche());
    }

    public void addGuiche(int quantidade){
        for (int i = 0 ; i < quantidade ; i++) this.guiches.add(new Guiche());
    }

    public void removeGuiche(int numeroGuiche){
        this.guiches.remove(numeroGuiche);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}