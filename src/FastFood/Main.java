package FastFood;

public class Main {

    public static void main(String[] args) {
        Restaurante titan = new Restaurante("TITAN", "0100103");
        titan.addGuiche(4);

        titan.guiches.get(0).addPedido(Cardapio.AMERICANO);
        titan.guiches.get(0).addPedido(Cardapio.HAMBURGUER);
        titan.guiches.get(0).addPedido(Cardapio.MISTO);
        titan.guiches.get(0).addPedido(Cardapio.REFRI);


        for(Pedido pedido : titan.guiches.get(0).getPedidos()){
            System.out.println(pedido.toString());
        }

        System.out.println( "montante= " + titan.guiches.get(0).getMontante());

        titan.relocatePedidos(0);
        for (Guiche guiche : titan.guiches){
            System.out.println(guiche.getPedidos());
        }
    }
}
