package Interface;

import Utils.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Receberá a quantidade de guiches do restaurante
 * ok: Verificará a validade do input:
 *     - Se valido, Segue para a próxima janela
 *     - caso contrário, abre mensagem de erro e mantém na janela atual
 */
public class QuantidadeGuichesInterface extends JFrame implements CoresTitanicas, FontesTitanicas{
	private JPanel container;
	private JLabel quantidadeGuiches;
	private JTextField inputQuantidadeGuiches;
	private JButton ok;
	private JPanel quantidadeGuichesInterface;

	public QuantidadeGuichesInterface() throws HeadlessException {
		//==== Conficuração inicial do painel ====
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(quantidadeGuichesInterface);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		//=========================================

		//==== texto Quantidade de guiches ====
		quantidadeGuiches.setFont(fonte16);
		quantidadeGuichesInterface.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		//======================================

		//==== botão ok ====
		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);
		ok.addActionListener(e -> {
			String inputUser = inputQuantidadeGuiches.getText();
			//Se for int, segue o fluxo de validação
			//Caso contrário, aparece mensagem de erro
			if(Input.checkInputIsInt(inputUser,quantidadeGuichesInterface)) {
				if (Input.checkInputIsPositivoNaoNulo(inputUser,quantidadeGuichesInterface)) {
					//Se for positivo não nulo, segue o fluxo de validação
					//Caso contrário, aparece mensagem de erro
					Input.setQuantidadeGuiches(Integer.parseInt(inputUser));
					QuantidadeGuichesInterface.super.setVisible(false);//fecha janela atual
					NomeAtendentes nomeAtendentes = new NomeAtendentes();
					nomeAtendentes.setVisible(true);//abre proxima janela
				}
			}
			System.out.println("Numero de guiches escolhido: " + Input.getQuantidadeGuiches());
		});
		//===========================
	}
}
