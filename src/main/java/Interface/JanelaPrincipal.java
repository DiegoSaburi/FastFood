package Interface;

import FastFood.Cardapio;
import FastFood.Restaurante;
import Utils.Input;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame implements CoresTitanicas, FontesTitanicas {
	private JPanel panelJanelaPrincipal;
	private JPanel containerInfoRestaurante;
	private JLabel labelNomeRestaurante;
	private JLabel labelCnpj;
	private JLabel labelTextoMontante;
	private JLabel labelValorMontante;
	private JLabel labelTextoGerente;
	private JLabel labelValorGerente;
	private JPanel containerGuiches;
	private JButton botaoFazerPedido;
	private JPanel containerBotaoFazerPedido;
	private JTable table1;

	public JanelaPrincipal() {
		Restaurante titan = new Restaurante("TITAN", "0100103", Input.getNomeGerente());
		titan.addGuiche(Input.nomeAtendentes);
		System.out.println(titan);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelJanelaPrincipal);
		this.setPreferredSize(new Dimension(1024,720));
		this.pack();

		this.containerInfoRestaurante.setBackground(CoresTitanicas.amareloEscuro);
		this.panelJanelaPrincipal.setBackground(CoresTitanicas.azul);

		this.labelNomeRestaurante.setFont(fonte12);
		this.labelNomeRestaurante.setText(titan.getNome());

		this.labelCnpj.setFont(fonte12);
		this.labelCnpj.setText(titan.getCnpj());

		this.labelTextoGerente.setFont(fonte12);
		this.labelTextoGerente.setText("Gerente: ");
		this.labelValorGerente.setFont(fonte12);
		this.labelValorGerente.setText(titan.getGerente().getNome());

		this.labelTextoMontante.setFont(fonte12);
		this.labelTextoMontante.setText("Montante: ");

		this.labelValorMontante.setFont(fonte12);
		this.labelValorMontante.setText(Double.toString(Restaurante.getMontante()));

		this.containerBotaoFazerPedido.setBackground(CoresTitanicas.amareloEscuro);
		botaoFazerPedido.setBackground(CoresTitanicas.cinza);
		botaoFazerPedido.setForeground(CoresTitanicas.amareloEscuro);
		botaoFazerPedido.setFont(fonte16);

	}
}
