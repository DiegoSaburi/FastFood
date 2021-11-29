package Utils;

import FastFood.Cardapio;
import org.apache.commons.lang3.EnumUtils;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Classe para armazenar e validar os dados
 * obtidos pelo usuário da aplicação
 */
public class Input {
	private static int quantidadeGuiches;
	public static ArrayList <String> nomeAtendentes = new ArrayList<>();
	private static String nomeGerente;
	private static int guicheEscolhido;
	private static String lanchePedido;

	/**
	 * Retorna um objeto da classe Input
	 */
	public Input() {

	}

	/**
	 * Retorna nome do gerente dado pelo usuário
	 * @return nome gerente dado pelo usuário
	 */
	public static String getNomeGerente() {
		return nomeGerente;
	}

	/**
	 * Seta o nome do gerente
	 * @param nomeGerente - nome do gerente
	 */
	public static void setNomeGerente(String nomeGerente) {
		Input.nomeGerente = nomeGerente;
	}

	/**
	 * Retorna o nome do lanche pedido pelo usuário
	 * @return nome do lanche dado pelo usuário
	 */
	public static String getLanchePedido() {
		return lanchePedido;
	}

	/**
	 * Seta o nome do lanche pedido pelo usuário
	 * @param lanchePedido - nome do lanche dado pelo usuário
	 */
	public static void setLanchePedido(String lanchePedido) {
		if(checkCardapioContemString(lanchePedido)) {
			Input.lanchePedido = lanchePedido;
		}
	}

	/**
	 * Retorna se a string passada é int
	 * @param str - string
	 * @return true - Se for int
	 *         false - caso contrário
	 */
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

	/**
	 * valida se o input do usuário é int
	 * @param inputUser - input do usuário
	 * @param contentPanel - panel da janela utilizada no momento da validação do input
	 * @return true - Se input é int
	 *         false - Se input não é int, abre error dialog
	 */
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

	/**
	 * Valida se o input do usuário é um positivo não nulo
	 * @param inputUser - input do usuário
	 * @param contentPanel - panel da janela utilizada no momento da validação do input
	 * @return true - Se input é positivo não nulo
	 *         false - caso contrário, abre error dialog
	 */
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

	/**
	 * Valida se o input do usuário é menor que um valor dado
	 * @param inputUser input do usuário
	 * @param valorComparador valor a ser comparado
	 * @param contentPanel panel da janela utilizada no momento da validação do input
	 * @return
	 */
	public static boolean checkInputIsMenor(String inputUser, int valorComparador, JPanel contentPanel){
		if (!(Integer.parseInt(inputUser) < valorComparador)) {
			JOptionPane.showMessageDialog(contentPanel,
					"Entre com um numero menor que " + valorComparador + "!",
					"error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Seta a quantidade de guiches escolhida pelo usuário
	 * @param quantidadeGuiches quantidade de guiches escolhida
	 * @return true - se for maior que 0; false - caso contrário
	 */
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
