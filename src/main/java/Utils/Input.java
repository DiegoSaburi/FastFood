package Utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe para armazenar os dados
 * obtidos pelo usuário da aplicação
 */
public class Input {
	private static int quantidadeGuiches;
	private static ArrayList <String> nomeAtendentes;
	private static int guicheEscolhido;

	public Input() {

	}

	public int getQuantidadeGuiches() {
		return quantidadeGuiches;
	}

	public static boolean isInt(String str) {
		if (str == null) {
			return false;
		}
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean setQuantidadeGuiches(int quantidadeGuiches) {
		if (quantidadeGuiches > 0){
			Input.quantidadeGuiches = quantidadeGuiches;
			 return true;
		}
		return false;
	}

	public ArrayList<String> getNomeAtendentes() {
		return nomeAtendentes;
	}

	public void setNomeAtendentes(ArrayList<String> nomeAtendentes) {
		Input.nomeAtendentes = nomeAtendentes;
	}

	public int getGuicheEscolhido() {
		return guicheEscolhido;
	}

	public void setGuicheEscolhido(int guicheEscolhido) {
		Input.guicheEscolhido = guicheEscolhido;
	}
}
