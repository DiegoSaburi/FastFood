package FastFood;

import java.util.ArrayList;

public class Guiche {
	private static int totalGuiches = 0;
	private ArrayList<Pedido> pedidos;
	private double montante;
	private Atendente atendente;
	private int numeroGuiche;

	/**
	 * Retorna um objeto da clase Guichê, contém agregação forte com restaurante
	 * @param nomeAtendente - nome do atendente a ser implementado na classe Atendente
	 */
	public Guiche(String nomeAtendente){
		this.pedidos = new ArrayList<>();
		this.montante = 0;
		this.numeroGuiche = totalGuiches;
		totalGuiches += 1;
		this.atendente = new Atendente(nomeAtendente);
	}

	/**
	 * Verifica a presença do pedido na lista de pedidos do guichê
	 * @param numeroPedido
	 * @return true - lista de pedidos contém
	 *          false - lista de pedidos não contém
	 */
	public boolean pedidoExiste(int numeroPedido){
		for(Pedido pedido: this.pedidos){
			if(pedido.getNumeroPedido() == numeroPedido) return true;
		}
		return false;
	}

	/**
	 * Adiciona um pedido á lista de pedidos do guichê
	 * @param cardapio - Enum contendo o pedido
	 * @return true - Se o pedido foi adicionado
	 *      false - Se o pedido não foi adicionado
	 */
	public boolean addPedido(Cardapio cardapio){
		this.montante += cardapio.valor;
		Restaurante.addMontante(cardapio.valor);
		this.atendente.addBonificacao(cardapio.valor);
		return this.pedidos.add(new Pedido(cardapio));
	}

	/**
	 * Retorna o atendente do guiche
	 * @return Atendente do guichê
	 */
	public Atendente getAtendente() {
		return atendente;
	}

	/**
	 * Seta o atendente do guichê
	 * @param nome - nome do Atendente
	 */
	public void setAtendente(String nome ) {
		this.atendente = new Atendente(nome);
	}

	/**
	 * Retorna o total de guiches instânciados
	 * @return total de guiches instânciados
	 */
	public static int getTotalGuiches() {
		return totalGuiches;
	}

	/**
	 * Seta o total de guiches instânciados
	 * @param totalGuiches - total de guiches instânciados
	 */
	public static void setTotalGuiches(int totalGuiches) {
		Guiche.totalGuiches = totalGuiches;
	}

	/**
	 * Retorna o index do guiche
	 * @return index do guiche
	 */
	public int getNumeroGuiche() {
		return numeroGuiche;
	}

	/**
	 * seta o index do guiche
	 * @param numeroGuiche - index do guiche
	 */
	public void setNumeroGuiche(int numeroGuiche) {
		this.numeroGuiche = numeroGuiche;
	}

	/**
	 * Retorna a lista de pedidos do guiche
	 * @return lista de pedidos do guiche
	 */
	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}

	/**
	 * seta a lista de pedidos do guiche
	 * @param pedidos - array contendo enum dos pedidos
	 */
	public void setPedidos(ArrayList<Cardapio> pedidos) {
		ArrayList<Pedido> novaListaPedidos = new ArrayList<>();
		for (Cardapio c : pedidos) {
			novaListaPedidos.add(new Pedido(c));
		}
		this.pedidos = novaListaPedidos;
	}

	/**
	 * Retorna o montante adquirido pelo guiche
	 * @return montante do guiche
	 */
	public double getMontante(){
		return montante;
	}

	/**
	 * Seta o montante adquirido pelo guiche
	 * @param montante - montante do guiche
	 */
	public void setMontante(double montante) {
		this.montante = montante;
	}

	/**
	 * Remove o pedido com base em seu index
	 * @param numeroPedido - index do pedido
	 * @return true - Se o pedido existe e foi removido
	 *         false - se o pedido não existe
	 */
	public boolean removePedido(int numeroPedido){
		for (Pedido pedido : this.pedidos){
			if (pedido.equals(numeroPedido)){
				this.montante -= pedido.cardapio.valor;
			}
		}
		return this.pedidos.removeIf(pedido -> pedido.equals(numeroPedido));
	}

}