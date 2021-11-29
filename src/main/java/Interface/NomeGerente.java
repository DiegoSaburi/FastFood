package Interface;

import Utils.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NomeGerente extends JFrame implements CoresTitanicas, FontesTitanicas {
	private JPanel container;
	private JLabel labelNomeGerente;
	private JButton ok;
	private JTextField inputNomeGerente;
	private JPanel panelNomeGerente;

	public NomeGerente() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelNomeGerente);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		labelNomeGerente.setFont(fonte16);
		panelNomeGerente.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Input.setNomeGerente(inputNomeGerente.getText());
				System.out.println("Nome do gerente: " + Input.getNomeGerente());
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				NomeGerente.super.setVisible(false);
				janelaPrincipal.setVisible(true);
			}
		});

	}
}
