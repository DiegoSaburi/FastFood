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
	public static ArrayList <String> nomeAtendentes = new ArrayList<>();
	private static String nomeGerente;
	private static int guicheEscolhido;

	public Input() {

	}

	public static String getNomeGerente() {
		return nomeGerente;
	}

	public static void setNomeGerente(String nomeGerente) {
		Input.nomeGerente = nomeGerente;
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

	public static int getQuantidadeGuiches() {
		return quantidadeGuiches;
	}

	public static int getGuicheEscolhido() {
		return guicheEscolhido;
	}

	public static void setGuicheEscolhido(int guicheEscolhido) {
		Input.guicheEscolhido = guicheEscolhido;
	}
}
