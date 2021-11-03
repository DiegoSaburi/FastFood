package FastFood;

public enum Cardapio {
    HAMBURGUER(15.0), MISTO(5.50), AMERICANO(8.00), REFRI(4.00);
    public double valor;

    Cardapio(double valor){
        this.valor = valor;
    };
}
