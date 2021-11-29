package Interface;

import FastFood.*;
import Utils.Input;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

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
	private JPanel containerFazerPedido;
	private JTable tabelaGuiches;
	private JScrollPane scrollTabelaGuiches;
	private JTextField inputPedido;
	private JTextField inputGuiche;
	private JTable tabelaCardapio;
	private JPanel containerCardapio;
	private JLabel labelPedido;
	private JLabel labelGuiche;
	private JScrollPane scrollTabelaCardapio;
	private JLabel labelTextoBonificacaoGerente;
	private JLabel labelBonificacaoGerenteValor;
	private JLabel labelTextoNomeRestaurante;
	private JLabel labelTextoCnpj;

	public JanelaPrincipal() {
		Restaurante titan = new Restaurante("TITAN", "0100103", Input.getNomeGerente());
		titan.addGuiche(Input.nomeAtendentes);
		System.out.println(titan);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelJanelaPrincipal);
		this.setPreferredSize(new Dimension(1920,1080));
		this.pack();

		this.containerInfoRestaurante.setBackground(CoresTitanicas.amareloEscuro);
		this.panelJanelaPrincipal.setBackground(CoresTitanicas.azul);

		this.labelTextoNomeRestaurante.setFont(fonte16);
		this.labelTextoNomeRestaurante.setText("Nome do Restaurante: ");
		this.labelNomeRestaurante.setFont(fonte16);
		this.labelNomeRestaurante.setText(titan.getNome());

		this.labelTextoCnpj.setFont(fonte16);
		this.labelTextoCnpj.setText("CNPJ: ");
		this.labelCnpj.setFont(fonte16);
		this.labelCnpj.setText(titan.getCnpj());

		this.labelTextoGerente.setFont(fonte16);
		this.labelTextoGerente.setText("Gerente: ");
		this.labelValorGerente.setFont(fonte16);
		this.labelValorGerente.setText(titan.getGerente().getNome());

		this.labelTextoBonificacaoGerente.setFont(fonte16);
		this.labelTextoBonificacaoGerente.setText("Bonificação: ");
		this.labelBonificacaoGerenteValor.setFont(fonte16);
		this.labelBonificacaoGerenteValor.setText(Double.toString(titan.getGerente().bonificacaoTotal()));

		this.labelTextoMontante.setFont(fonte16);
		this.labelTextoMontante.setText("Montante: ");
		this.labelValorMontante.setFont(fonte16);
		this.labelValorMontante.setText(Double.toString(Restaurante.getMontante()));

		this.labelGuiche.setFont(fonte16);
		this.labelPedido.setFont(fonte16);

		createTable(tabelaGuiches,new String[]{"Numero do Guiche","Atendente", "Pedidos", "Valor arrecadado","Bonificação do atendente"});
		conteudoTabelaGuiches(titan);
		tabelaGuiches.setFont(fonte16);
		tabelaGuiches.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JTableHeader headerTabelaGuiches = tabelaGuiches.getTableHeader();
		headerTabelaGuiches.setFont(fonte32);

		Object[][] conteudoTabelaCarpadio = {
				Cardapio.AMERICANO.toArray(),
				Cardapio.HAMBURGUER.toArray(),
				Cardapio.MISTO.toArray(),
				Cardapio.REFRI.toArray()
		};
		String[] nomeColunasCardapio = {"Pedido","Valor"};
		createTable(tabelaCardapio,conteudoTabelaCarpadio,nomeColunasCardapio);
		tabelaCardapio.setFont(fonte16);
		JTableHeader headerTabelaCarpaio = tabelaCardapio.getTableHeader();
		headerTabelaCarpaio.setFont(fonte32);

		containerCardapio.setBackground(CoresTitanicas.amareloEscuro);
		scrollTabelaCardapio.setBackground(CoresTitanicas.amareloEscuro);

		this.containerFazerPedido.setBackground(CoresTitanicas.amareloEscuro);

		botaoFazerPedido.setBackground(CoresTitanicas.cinza);
		botaoFazerPedido.setForeground(CoresTitanicas.amareloEscuro);
		botaoFazerPedido.setFont(fonte16);
		botaoFazerPedido.addActionListener(e -> {
			boolean guicheValido = false;
			boolean pedidoValido = false;
			String inputUserGuiche = inputGuiche.getText();
			String inputUserPedido = inputPedido.getText();
			System.out.println("inputUserPedido: " + inputUserPedido);
			System.out.println("inputUserGuiche: " + inputUserGuiche);

			if(Input.checkInputIsInt(inputUserGuiche,panelJanelaPrincipal)) {
				if (Input.checkInputIsPositivoNaoNulo(inputUserGuiche,panelJanelaPrincipal)) {
					if(Input.checkInputIsMenor(inputUserGuiche,Input.getQuantidadeGuiches(), panelJanelaPrincipal)) {
						Input.setGuicheEscolhido(Integer.parseInt(inputUserGuiche));
						guicheValido = true;
					}
				}
			}

			if(Input.checkInputCardapioContemString(inputUserPedido.toUpperCase(),panelJanelaPrincipal)){
				Input.setLanchePedido(inputUserPedido);
				pedidoValido = true;
			}

			if(pedidoValido&&guicheValido){
				titan.getGuiches().get(Input.getGuicheEscolhido()).addPedido(Cardapio.valueOf(inputUserPedido.toUpperCase()));
				System.out.println("Pedido: " + titan.getGuiches().get(Input.getGuicheEscolhido()).getPedidos());
				updateTabela(tabelaGuiches,titan.getGuiches().get(Input.getGuicheEscolhido()));
				updateRowHeights(tabelaGuiches);
				updateInfoRestaurante(titan);
			}

		});
	}
	private void updateRowHeights(JTable table)
	{
		for (int row = 0; row < table.getRowCount(); row++)
		{
			int rowHeight = table.getRowHeight();

			for (int column = 0; column < table.getColumnCount(); column++)
			{
				Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
				rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
			}

			table.setRowHeight(row, rowHeight);
		}
	}
	private void updateInfoRestaurante(Restaurante restaurante){
		this.labelValorMontante.setText(Double.toString(Restaurante.getMontante()));
		this.labelBonificacaoGerenteValor.setText(Double.toString(restaurante.getGerente().bonificacaoTotal()));
	}

	private void updateTabela(JTable table,Guiche guiche){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setValueAt(guiche.getPedidos(), guiche.getNumeroGuiche(), 2);
		model.setValueAt(guiche.getMontante(), guiche.getNumeroGuiche(), 3);
		model.setValueAt(guiche.getAtendente().getBonificacaoTotal(), guiche.getNumeroGuiche(), 4);
	}

	public Object[] conteudoLinha(Guiche guiche){
		ArrayList<Object> row = new ArrayList<>();
		row.add(guiche.getNumeroGuiche());
		row.add(guiche.getAtendente().toString());
		row.add(guiche.getPedidos().toString());
		row.add(Double.toString(guiche.getMontante()));
		row.add(Double.toString(guiche.getAtendente().getBonificacaoTotal()));
		return row.toArray();
	}

	private void addRow(JTable table,Guiche guiche){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(conteudoLinha(guiche));
	}

	private void conteudoTabelaGuiches(Restaurante restaurante){
		for (int i = 0; i < Input.getQuantidadeGuiches(); i++) {
			addRow(tabelaGuiches,restaurante.getGuiches().get(i));
		}
	}

	private void createTable(JTable table, String[] nomeColunas ){
		table.setModel(new DefaultTableModel(
				null,
				nomeColunas
		));
	}

	private void createTable( JTable table, Object[][] data, String[] nomeColunas ){
		table.setModel(new DefaultTableModel(
				data,
				nomeColunas
		));
	}
}
