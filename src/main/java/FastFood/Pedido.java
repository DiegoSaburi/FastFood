package FastFood;

import java.util.Objects;

public class Pedido {

	public static int totalPedido = 0;
	private int numeroPedido;
	public Cardapio cardapio;

	//construtores:
	/**
	 * Retorna um objeto da classe Pedido indicando o seu número, tem agregação forte com guichê
	 * @param numeroPedido - numero do pedido(id)
	 * @param cardapio - enum do pedido(contem nome do lanche e valor)
	 */
	public Pedido(int numeroPedido, Cardapio cardapio) {
		this.numeroPedido = numeroPedido;
		this.cardapio = cardapio;
	}

	/**
	 * Retorna um objeto da classe Pedido (numero gerado sequencialmente), tem agregação forte com guichê
	 * @param cardapio - enum do pedido(contem nome do lanche e valor)
	 */
	public Pedido(Cardapio cardapio) {
		this.cardapio = cardapio;
		totalPedido +=1;
		this.numeroPedido = totalPedido;
	}

	@Override
	public String toString() {
		return cardapio.nomePedido;
	}

	public boolean equals(int numeroPedido) {
		return this.getNumeroPedido() == numeroPedido;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pedido pedido)) return false;
		return getNumeroPedido() == pedido.getNumeroPedido();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumeroPedido());
	}

	/**
	 * Retorna o enum do pedido
	 * @return pedido
	 */
	public Cardapio getCardapio() {
		return cardapio;
	}

	/**
	 * Seta o enum do pedido
	 * @param cardapio - enum do pedido
	 */
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	/**
	 * Retorna o numero do pedido(id)
	 * @return id do pedido
	 */
	public int getNumeroPedido(){
		return  numeroPedido;
	}

	/**
	 * seta o numero do pedido(id)
	 * @param numeroPedido - id do pedido
	 */
	public void setNumeroPedido(int numeroPedido){
		this.numeroPedido = numeroPedido;
	}

}