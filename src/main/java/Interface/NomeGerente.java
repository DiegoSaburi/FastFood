package Interface;

import Utils.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Receberá o nome do gerente do restaurante
 * ok: Salvará o input e seguirá para a próxima janela
 */
public class NomeGerente extends JFrame implements CoresTitanicas, FontesTitanicas {
	private JPanel container;
	private JLabel labelNomeGerente;
	private JButton ok;
	private JTextField inputNomeGerente;
	private JPanel panelNomeGerente;

	public NomeGerente() {
		//==== Conficuração inicial do painel ====
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelNomeGerente);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		//=======================================

		//====texto nome gerente ====
		labelNomeGerente.setFont(fonte16);
		panelNomeGerente.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		//============================

		//==== botão ok ====
		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Input.setNomeGerente(inputNomeGerente.getText());
				System.out.println("Nome do gerente: " + Input.getNomeGerente());
				JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
				NomeGerente.super.setVisible(false);//fecha janela atual
				janelaPrincipal.setVisible(true);//abre proxima janela
			}
		});
		//==================
	}
}
