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

/**
 * Janela principal do restaurante, cuidará de todo o fluxo de pedidos e bonificação
 * Guiche: input que recebe o numero do guiche escolhido
 * Pedido: input que recebe o nome do pedido
 * Fazer pedido: Validará o input de guiche e pedido
 *               - Se válido, adicionará o pedido ao guiche escolhido e atualizará as tabelas e as bonificações
 *               - Caso contrário, não adiciona e mantém na janela atual
 */
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
		titan.setGuiches(Input.nomeAtendentes);
		System.out.println(titan);

		//==== Conficuração inicial do painel ====
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panelJanelaPrincipal);
		this.setPreferredSize(new Dimension(1920,1080));
		this.pack();
		//========================================

		//==== configuração dos containers e do panel principal ====
		this.containerInfoRestaurante.setBackground(CoresTitanicas.amareloEscuro);
		this.panelJanelaPrincipal.setBackground(CoresTitanicas.azul);
		//===========================================================

		//==== texto nome restaurante ====
		this.labelTextoNomeRestaurante.setFont(fonte16);
		this.labelTextoNomeRestaurante.setText("Nome do Restaurante: ");
		this.labelNomeRestaurante.setFont(fonte16);
		this.labelNomeRestaurante.setText(titan.getNome());
		//================================

		//==== texto cnpj ====
		this.labelTextoCnpj.setFont(fonte16);
		this.labelTextoCnpj.setText("CNPJ: ");
		this.labelCnpj.setFont(fonte16);
		this.labelCnpj.setText(titan.getCnpj());
		//===================

		//==== texto gerente ====
		this.labelTextoGerente.setFont(fonte16);
		this.labelTextoGerente.setText("Gerente: ");
		this.labelValorGerente.setFont(fonte16);
		this.labelValorGerente.setText(titan.getGerente().getNome());
		//=======================

		//==== texto bonificação gerente ====
		this.labelTextoBonificacaoGerente.setFont(fonte16);
		this.labelTextoBonificacaoGerente.setText("Bonificação: ");
		this.labelBonificacaoGerenteValor.setFont(fonte16);
		this.labelBonificacaoGerenteValor.setText(Double.toString(titan.getGerente().bonificacaoTotal()));
		//===================================

		//==== texto montante do restaurante ====
		this.labelTextoMontante.setFont(fonte16);
		this.labelTextoMontante.setText("Montante: ");
		this.labelValorMontante.setFont(fonte16);
		this.labelValorMontante.setText(Double.toString(Restaurante.getMontante()));
		//========================================

		//==== texto fazer pedido ====
		this.labelGuiche.setFont(fonte16);
		this.labelPedido.setFont(fonte16);
		//============================

		//==== Tabela de informações dos guiches ====
		createTable(tabelaGuiches,new String[]{"Numero do Guiche","Atendente", "Pedidos", "Valor arrecadado","Bonificação do atendente"});
		conteudoTabelaGuiches(titan);
		tabelaGuiches.setFont(fonte16);
		tabelaGuiches.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);//aumenta a altura das células
		JTableHeader headerTabelaGuiches = tabelaGuiches.getTableHeader();
		headerTabelaGuiches.setFont(fonte32);//seta fonte do header da tabela
		//=========================================

		//==== Tabela do cardápio ====
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
		headerTabelaCarpaio.setFont(fonte32);//seta fonte do header da tabela
		containerCardapio.setBackground(CoresTitanicas.amareloEscuro);
		scrollTabelaCardapio.setBackground(CoresTitanicas.amareloEscuro);
		//============================

		//==== fazer um pedido ====
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
				//Se for int, segue o fluxo de validação
				//Caso contrário, aparece mensagem de erro
				if (Input.checkInputIsPositivoNaoNulo(inputUserGuiche,panelJanelaPrincipal)) {
					//Se for positivo não nulo, segue o fluxo de validação
					//Caso contrário, aparece mensagem de erro
					if(Input.checkInputIsMenor(inputUserGuiche,Input.getQuantidadeGuiches(), panelJanelaPrincipal)) {
						//Se for menor que o tamanho do array de guiches, salva o input
						//Caso contrário, aparece mensagem de erro
						Input.setGuicheEscolhido(Integer.parseInt(inputUserGuiche));
						guicheValido = true;
					}
				}
			}

			if(Input.checkInputCardapioContemString(inputUserPedido.toUpperCase(),panelJanelaPrincipal)){
				//Se o cardápio contém o input, salva o input
				//Caso contrário, aparece mensagem de erro
				Input.setLanchePedido(inputUserPedido);
				pedidoValido = true;
			}

			if(pedidoValido&&guicheValido){
				titan.getGuiches().get(Input.getGuicheEscolhido()).addPedido(Cardapio.valueOf(inputUserPedido.toUpperCase()));//adiciona pedido ao guiche escolhido
				System.out.println("Pedido: " + titan.getGuiches().get(Input.getGuicheEscolhido()).getPedidos());
				updateTabela(tabelaGuiches,titan.getGuiches().get(Input.getGuicheEscolhido()));//atualiza tabela com novas informações
				updateRowHeights(tabelaGuiches);//atualiza altura das células
				updateInfoRestaurante(titan);//atualiza container contendo info do restaurante e do gerente
			}

		});
		//================================
	}

	/**
	 * Atualiza o tamanho das células de forma a melhorar visualização
	 * @param table - tabela a ser utilizada
	 */
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

	/**
	 * Atualiza as informações do container de infos do restaurante
	 * @param restaurante - Restaurante contendo as informações
	 */
	private void updateInfoRestaurante(Restaurante restaurante){
		this.labelValorMontante.setText(Double.toString(Restaurante.getMontante()));
		this.labelBonificacaoGerenteValor.setText(Double.toString(restaurante.getGerente().bonificacaoTotal()));
	}

	/**
	 * Atualiza tabela com as novas informações do pedido e dos guichês utilizados que são:
	 * lista de pedidos, montante do guiche, bonificação do atendente
	 * @param table - tabela a ser atualizada
	 * @param guiche - guiche contendo as informações
	 */
	private void updateTabela(JTable table,Guiche guiche){
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setValueAt(guiche.getPedidos(), guiche.getNumeroGuiche(), 2);
		model.setValueAt(guiche.getMontante(), guiche.getNumeroGuiche(), 3);
		model.setValueAt(guiche.getAtendente().getBonificacaoTotal(), guiche.getNumeroGuiche(), 4);
	}

	/**
	 * Retorna um array contendo as informações de um guiche
	 * @implNote Função criada com base na row da tabela de guiches da janela principal
	 * @param guiche - guiche contendo as informações, que são: número,nome do atendente, lista de pedidos, montante do guiche, bonificação do atendente
	 * @return array de string contendo informações do guiche
	 */
	public Object[] conteudoLinha(Guiche guiche){
		ArrayList<Object> row = new ArrayList<>();
		row.add(guiche.getNumeroGuiche());
		row.add(guiche.getAtendente().toString());
		row.add(guiche.getPedidos().toString());
		row.add(Double.toString(guiche.getMontante()));
		row.add(Double.toString(guiche.getAtendente().getBonificacaoTotal()));
		return row.toArray();
	}

	/**
	 * Adiciona uma nova linha á tabela
	 * @implNote Função criada com base na função conteudoLinha
	 * @param table - tabela a ser atualizada
	 * @param guiche - guiche contendo as informações, que são: número,nome do atendente, lista de pedidos, montante do guiche, bonificação do atendente
	 */
	private void addRow(JTable table,Guiche guiche){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(conteudoLinha(guiche));
	}

	/**
	 * Cria o conteudo inicial da tabela de guiches
	 * @implNote [ATENÇÃO] UTILIZADA APENAS NA HORA DE CRIAR A TABELA GUICHES
	 * @param restaurante - Restaurante contendo as informações que são: Lista de guiches
	 */
	private void conteudoTabelaGuiches(Restaurante restaurante){
		for (int i = 0; i < Input.getQuantidadeGuiches(); i++) {
			addRow(tabelaGuiches,restaurante.getGuiches().get(i));
		}
	}

	/**
	 * Cria a tabela apenas com header
	 * @param table - tabela a ser criada
	 * @param nomeColunas - nome dos headers
	 */
	private void createTable(JTable table, String[] nomeColunas ){
		table.setModel(new DefaultTableModel(
				null,
				nomeColunas
		));
	}

	/**
	 * Cria a tabela contendo um conteúdo prédefinido
	 * @param table - tabela a ser criada
	 * @param data - conteudo da tabela
	 * @param nomeColunas - nome dos headers
	 */
	private void createTable( JTable table, Object[][] data, String[] nomeColunas ){
		table.setModel(new DefaultTableModel(
				data,
				nomeColunas
		));
	}
}
