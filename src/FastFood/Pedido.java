package FastFood;

import java.util.Objects;

public class Pedido {

	public static int totalPedido = 0;
	private int numeroPedido;
	public Cardapio cardapio;

	public Pedido(int numeroPedido, Cardapio cardapio) {
		this.numeroPedido = numeroPedido;
		this.cardapio = cardapio;
	}

	@Override
	public String toString() {
		return "Número do pedido= " + this.numeroPedido+
				" pedido=" + this.cardapio +
				" valor= " + this.cardapio.valor;
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

	public Pedido(Cardapio cardapio) {
		this.cardapio = cardapio;
		totalPedido +=1;
		this.numeroPedido = totalPedido;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public int getNumeroPedido(){
		return  numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido){
		this.numeroPedido = numeroPedido;
	}

}