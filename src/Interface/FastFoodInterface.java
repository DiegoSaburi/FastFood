package Interface;

import Utils.Input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastFoodInterface extends JFrame implements CoresTitanicas, FontesTitanicas {
	private JPanel Inicio;
	private JLabel boasVindas;
	private JButton sair;
	private JButton continuar;
	private JPanel container;

	public FastFoodInterface(String titulo, Input input){
		super(titulo);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(Inicio);
		this.setLocationRelativeTo(null);
		this.setSize(640,480);
		this.pack();
		boasVindas.setFont(fonte32);
		Inicio.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		sair.setBackground(CoresTitanicas.cinza);
		sair.setForeground(CoresTitanicas.amareloEscuro);
		sair.setFont(fonte16);
		continuar.setBackground(CoresTitanicas.cinza);
		continuar.setForeground(CoresTitanicas.amareloEscuro);
		continuar.setFont(fonte16);
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FastFoodInterface.super.dispose();
			}
		});
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro(input);
				FastFoodInterface.super.setVisible(false);
				cadastro.setVisible(true);
			}
		});
	}
}
