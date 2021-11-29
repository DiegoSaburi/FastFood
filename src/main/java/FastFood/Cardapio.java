package FastFood;

import java.util.ArrayList;

public enum Cardapio {
	HAMBURGUER("hamburguer",15.0),
	MISTO("misto", 5.50),
	AMERICANO("americano", 8.00),
	REFRI("refri", 4.00);

	public double valor;
	public String nomePedido;

	/**
	 * Retorna o nome do lanche e seu valor referente
	 * @return [nome do lanche, valor do lanche]
	 */
	public Object[] toArray(){
		ArrayList<String> toArrayList = new ArrayList<>();
		toArrayList.add(nomePedido);
		toArrayList.add(Double.toString(valor));
		return toArrayList.toArray();
	}

	Cardapio(String nomePedido,double valor){
		this.valor = valor;
		this.nomePedido = nomePedido;
	}
}
