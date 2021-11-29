package FastFood;
import java.util.ArrayList;
import java.util.Collections;

public class Restaurante {
    private String nome;
    private ArrayList<Guiche> guiches;
    private String cnpj;
    private static double montante = 0;
    private Gerente gerente;

    /**
     * Retorna um objeto da classe Restaurante
     * @param nomeRestaurante - nome do restaurante
     * @param cnpj - cnpj do restaurante
     * @param nomeGerente - nome do gerente do restaurante
     */
	public Restaurante(String nomeRestaurante, String cnpj, String nomeGerente) {
		this.nome = nomeRestaurante;
		this.cnpj = cnpj;
		this.guiches = new ArrayList<>();
        this.gerente = new Gerente(nomeGerente);
	}

    /**
     * Retorna o nome do restaurante
     * @return nome do restaurante
     */
    public String getNome() {
        return nome;
    }

    /**
     * seta o nome do restaurante
     * @param nome - nome do restaurante
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a lista de guichês do restaurante
     * @return lista de guichês do restaurante
     */
    public ArrayList<Guiche> getGuiches() {
        return guiches;
    }

    /**
     * Seta a lista de guiches do restaurante
     * @param nomeAtendentesGuiches - lista contendo nomes dos atendentes dos guiches
     */
    public void setGuiches(ArrayList<String> nomeAtendentesGuiches) {
        ArrayList<Guiche> novaListaGuiches = new ArrayList<>();
        for (String n : nomeAtendentesGuiches   ) {
            novaListaGuiches.add(new Guiche(n));
        }
        this.guiches = novaListaGuiches;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", gerente=" + gerente +
                '}';
    }

    /**
     * adiciona um novo guichê à lista de guiches do restaurante
     * @param nomeAtendente - nome do atendente do guichê adicionado
     */
    public void addGuiche(String nomeAtendente){
        this.guiches.add(new Guiche(nomeAtendente));
    }
    /**
     * adiciona um array de guichês à lista de guiches do restaurante
     * @param nomeAtendentes - array contendo nomes dos atendentes dos guichês adicionados
     */
    public void addGuiche(ArrayList<String> nomeAtendentes){
        for (String nomeAtendente : nomeAtendentes) this.guiches.add(new Guiche(nomeAtendente));
    }

    /**
     * remove guichê específico com base no seu index
     * @param numeroGuiche - index do guiche a ser removido
     */
    public void removeGuiche(int numeroGuiche){
        this.guiches.remove(numeroGuiche);
    }

    /**
     * retorna o gerente do restaurante
     * @return gerente do restaurante
     */
    public Gerente getGerente() {
        return gerente;
    }

    /**
     * Seta o gerente do restaurante
     * @param nomeGerente - nome do gerente do restaurante
     */
    public void setGerente(String nomeGerente) {
        this.gerente = new Gerente(nomeGerente);
    }

    /**
     * Retorna o montante do restaurante
     * @return montante do restaurante
     */
    public static double getMontante() {
        return montante;
    }

    /**
     * Seta o montante do restaurante
     * @param montante - montante do restaurante
     */
    public static void setMontante(double montante) {
        Restaurante.montante = montante;
    }

    /**
     * Adicionar um valor ao montante do restaurante
     * @param valor - valor a ser adicionado ao montante
     */
    public static void addMontante(double valor){
        montante += valor;
    }

    /**
     * retorna cnpj do restaurante
     * @return cnpj do restaurante
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Seta o cnpj do restaurante
     * @param cnpj - cnpj do restaurante
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}