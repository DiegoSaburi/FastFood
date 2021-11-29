package Utils;

import FastFood.Cardapio;
import org.apache.commons.lang3.EnumUtils;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Classe para armazenar os dados
 * obtidos pelo usuário da aplicação
 */
public class Input {
	private static int quantidadeGuiches;
	public static ArrayList <String> nomeAtendentes = new ArrayList<>();
	private static String nomeGerente;
	private static int guicheEscolhido;
	private static String lanchePedido;

	public Input() {

	}

	public static String getNomeGerente() {
		return nomeGerente;
	}

	public static void setNomeGerente(String nomeGerente) {
		Input.nomeGerente = nomeGerente;
	}

	public static String getLanchePedido() {
		return lanchePedido;
	}

	public static void setLanchePedido(String lanchePedido) {
		if(checkCardapioContemString(lanchePedido)) {
			Input.lanchePedido = lanchePedido;
		}
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

	public static boolean checkInputIsInt(String inputUser, JPanel contentPanel){
		if(!Input.isInt(inputUser)){
			JOptionPane.showMessageDialog(contentPanel,
					"Entre com um numero inteiro!",
					"error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean checkInputIsPositivoNaoNulo(String inputUser, JPanel contentPanel){
		if (!(Integer.parseInt(inputUser) >= 0)) {
			JOptionPane.showMessageDialog(contentPanel,
					"Entre com um numero maior que 0!",
					"error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean checkInputIsMenor(String inputUser, int valorComparador, JPanel contentPanel){
		if (!(Integer.parseInt(inputUser) < valorComparador)) {
			JOptionPane.showMessageDialog(contentPanel,
					"Entre com um numero maior que " + valorComparador + "!",
					"error",
					JOptionPane.ERROR_MESSAGE);
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

	public static boolean setGuicheEscolhido(int guicheEscolhido) {
		if (guicheEscolhido > 0 && guicheEscolhido < Input.getQuantidadeGuiches()) {
			Input.guicheEscolhido = guicheEscolhido;
			return true;
		}
		return false;
	}



	public static boolean checkCardapioContemString( String nomeEnum){
		return EnumUtils.isValidEnum(Cardapio.class, nomeEnum);
	}

	public static boolean checkInputCardapioContemString(String inputUser, JPanel contentPanel){
		if (!checkCardapioContemString(inputUser)) {
			JOptionPane.showMessageDialog(contentPanel,
					"Peça um lanche que tenha no cardápio",
					"error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
