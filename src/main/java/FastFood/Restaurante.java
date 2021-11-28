package FastFood;
import java.util.ArrayList;
import java.util.Collections;

public class Restaurante {
    private String nome;
    private ArrayList<Guiche> guiches;
    private String cnpj;
    private static double montante = 0;
    private Gerente gerente;

	public Restaurante(String nomeRestaurante, String cnpj, String nomeGerente) {
		this.nome = nomeRestaurante;
		this.cnpj = cnpj;
		this.guiches = new ArrayList<>();
        this.gerente = new Gerente(nomeGerente);
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Guiche> getGuiches() {
        return guiches;
    }

    public void setGuiches(ArrayList<Guiche> guiches) {
        this.guiches = guiches;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", gerente=" + gerente +
                '}';
    }

    public void addGuiche(String nomeAtendente){
        this.guiches.add(new Guiche(nomeAtendente));
    }

    public void addGuiche(ArrayList<String> nomeAtendentes){
        for (String nomeAtendente : nomeAtendentes) this.guiches.add(new Guiche(nomeAtendente));
    }

    public void removeGuiche(int numeroGuiche){
        this.guiches.remove(numeroGuiche);
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public static double getMontante() {
        return montante;
    }

    public static void addMontante(double valor){
        montante += valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}