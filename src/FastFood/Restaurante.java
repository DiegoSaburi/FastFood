package FastFood;
import java.util.ArrayList;
import java.util.Collections;

public class Restaurante {
    public String nome;
    public ArrayList<Guiche> guiches;
    private String cnpj;

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

    public void relocatePedidos(int indexGuicheQuebrado){

        int quantidadeTotalGuiches = this.guiches.size();
        int quantidadeGuichesFuncionais = quantidadeTotalGuiches - 1;
        int quantidadePedidos =  this.guiches.get(indexGuicheQuebrado).getPedidos().size();

        Collections.swap(this.guiches, indexGuicheQuebrado, quantidadeTotalGuiches-1);

        System.out.println("realocando pedidos do guiche de número "+ indexGuicheQuebrado);
        System.out.println("Guiche de número " + (quantidadeTotalGuiches - 1)
                + " passou a ser guiche de número " + indexGuicheQuebrado);

        indexGuicheQuebrado = quantidadeTotalGuiches-1;

        for(int i = 0 ; i < quantidadePedidos ; i++){
            Pedido auxPedido = this.guiches.get(indexGuicheQuebrado).getPedidos().get(i);
            this.guiches
                    .get(i % quantidadeGuichesFuncionais)
                    .addPedido(auxPedido.getNumeroPedido(),auxPedido.cardapio);
        }
        this.guiches.get(indexGuicheQuebrado).removeAllPedidos();
    }

    public Restaurante(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.guiches = new ArrayList<Guiche>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}