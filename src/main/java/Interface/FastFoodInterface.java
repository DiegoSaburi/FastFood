package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de boas vindas
 * Sair: Fecha o programa
 * Continuar: Segue o fluxo de criação do restaurante
 */
public class FastFoodInterface extends JFrame implements CoresTitanicas,FontesTitanicas {
	private JPanel Inicio;
	private JLabel boasVindas;
	private JButton sair;
	private JButton continuar;
	private JPanel container;

	public FastFoodInterface(String titulo){
		super(titulo);
		//==== Conficuração inicial do painel ====
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(Inicio);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		//==========================================

		//==== texto de boas vindas ====
		boasVindas.setFont(fonte32);
		Inicio.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		//===============================

		//==== botão sair ====
		sair.setBackground(CoresTitanicas.cinza);
		sair.setForeground(CoresTitanicas.amareloEscuro);
		sair.setFont(fonte16);
		sair.addActionListener(e -> FastFoodInterface.super.dispose());
		//=====================

		//==== botão continuar ====
		continuar.setBackground(CoresTitanicas.cinza);
		continuar.setForeground(CoresTitanicas.amareloEscuro);
		continuar.setFont(fonte16);
		continuar.addActionListener(e -> {
			QuantidadeGuichesInterface quantidadeGuichesInterface = new QuantidadeGuichesInterface();
			FastFoodInterface.super.setVisible(false);//fecha janela atual
			quantidadeGuichesInterface.setVisible(true);//abre proxima janela
		});
		//==========================
	}
}
