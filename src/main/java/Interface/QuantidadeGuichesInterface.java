package Interface;

import Utils.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuantidadeGuichesInterface extends JFrame implements CoresTitanicas, FontesTitanicas{
	private JPanel container;
	private JLabel quantidadeGuiches;
	private JTextField inputQuantidadeGuiches;
	private JButton ok;
	private JPanel quantidadeGuichesInterface;

	public QuantidadeGuichesInterface() throws HeadlessException {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(quantidadeGuichesInterface);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();

		quantidadeGuiches.setFont(fonte16);

		quantidadeGuichesInterface.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);

		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);
		ok.addActionListener(e -> {
			String inputUser = inputQuantidadeGuiches.getText();
			if(Input.checkInputIsInt(inputUser,quantidadeGuichesInterface)) {
				if (Input.checkInputIsPositivoNaoNulo(inputUser,quantidadeGuichesInterface)) {
					Input.setQuantidadeGuiches(Integer.parseInt(inputUser));
					QuantidadeGuichesInterface.super.setVisible(false);
					NomeAtendentes nomeAtendentes = new NomeAtendentes();
					nomeAtendentes.setVisible(true);
				}
			}
			System.out.println("Numero de guiches escolhido: " + Input.getQuantidadeGuiches());
		});
	}
}
