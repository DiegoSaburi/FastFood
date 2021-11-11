package Utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe para armazenar os dados
 * obtidos pelo usuário da aplicação
 */
public class Input {
	private int quantidadeGuiches;
	private ArrayList <String> nomeAtendentes;
	private int guicheEscolhido;

	public Input() {

	}

	public int getQuantidadeGuiches() {
		return quantidadeGuiches;
	}

	public boolean setQuantidadeGuiches(int quantidadeGuiches) {
		if (quantidadeGuiches > 0){
			 this.quantidadeGuiches = quantidadeGuiches;
			 return true;
		}
		return false;
	}

	public ArrayList<String> getNomeAtendentes() {
		return nomeAtendentes;
	}

	public void setNomeAtendentes(ArrayList<String> nomeAtendentes) {
		this.nomeAtendentes = nomeAtendentes;
	}

	public int getGuicheEscolhido() {
		return guicheEscolhido;
	}

	public void setGuicheEscolhido(int guicheEscolhido) {
		this.guicheEscolhido = guicheEscolhido;
	}
}
