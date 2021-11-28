package Interface;

import Utils.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame implements CoresTitanicas, FontesTitanicas{
	private JPanel cadastro;
	private JPanel container;
	private JLabel quantidadeGuiches;
	private JTextField inputQuantidadeGuiches;
	private JButton ok;

	public Cadastro() throws HeadlessException {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(cadastro);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		quantidadeGuiches.setFont(fonte16);
		cadastro.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputUser = inputQuantidadeGuiches.getText();
				if(!Input.isInt(inputUser)){
					JOptionPane.showMessageDialog(cadastro,
							"Entre com um numero inteiro!",
							"error",
							JOptionPane.ERROR_MESSAGE);
				}
				else if(!Input.setQuantidadeGuiches(Integer.parseInt(inputUser))){
					JOptionPane.showMessageDialog(cadastro,
							"Entre com um numero maior que 0!",
							"error",
							JOptionPane.ERROR_MESSAGE);
				}else{
					Input.setQuantidadeGuiches(Integer.parseInt(inputUser));
					Cadastro.super.setVisible(false);
					NomeAtendentes nomeAtendentes = new NomeAtendentes();
					nomeAtendentes.setVisible(true);
				}
				System.out.println("Numero de guiches escolhido: " + Input.getQuantidadeGuiches());
			}
		});
	}
}
