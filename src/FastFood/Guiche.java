package FastFood;

import java.util.ArrayList;

public class Guiche {
	private static int totalGuiches = 0;
	private ArrayList<Pedido> pedidos;
	private double montante;

	public Guiche(){
		this.pedidos = new ArrayList<>();
		this.montante = 0;
		totalGuiches += 1;
	}

	public boolean pedidoExiste(int numeroPedido){
		for(Pedido pedido: this.pedidos){
			if(pedido.getNumeroPedido() == numeroPedido) return true;
		}
		return false;
	}

	public boolean addPedido(Cardapio cardapio){
		this.montante += cardapio.valor;
		return this.pedidos.add(new Pedido(cardapio));
	}

	public boolean addPedido(int numeroPedido,Cardapio cardapio){
		this.montante += cardapio.valor;
		return this.pedidos.add(new Pedido(numeroPedido,cardapio));
	}

	public ArrayList<Pedido> getPedidos(){
		return pedidos;
	}

	public double getMontante(){
		return montante;
	}

	public boolean removePedido(int numeroPedido){
		for (Pedido pedido : this.pedidos){
			if (pedido.equals(numeroPedido)){
				this.montante -= pedido.cardapio.valor;
			}
		}
		return this.pedidos.removeIf(pedido -> pedido.equals(numeroPedido));
	}

// Não fiz o setters pq imagino que os pedidos vão ser setados pelo addPedido, o montante vai ser definido pelos pedidos e o número Guiche é estático.

//Tem que ver de qualé dessa sobrescrita do método de remoer


}