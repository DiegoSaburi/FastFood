package Interface;

import Utils.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NomeAtendentes extends JFrame implements CoresTitanicas,FontesTitanicas{
	private JPanel container;
	private JLabel nomeAtendentesLabel;
	private JButton ok;
	private JTextField inputNomeAtendentes;
	private JPanel panel;
	private JLabel labelUltimoNomeAdicionado;
	private final String labelText = "Digite o nome do atendente do guiche ";

	public NomeAtendentes() throws HeadlessException {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(640,480));
		this.pack();
		nomeAtendentesLabel.setFont(fonte16);
		labelUltimoNomeAdicionado.setFont(fonte16);
		nomeAtendentesLabel.setText(labelText + Input.nomeAtendentes.size());
		panel.setBackground(CoresTitanicas.amareloEscuro);
		container.setBackground(CoresTitanicas.amareloEscuro);
		this.setBackground(CoresTitanicas.amareloEscuro);
		ok.setBackground(CoresTitanicas.cinza);
		ok.setForeground(CoresTitanicas.amareloEscuro);
		ok.setFont(fonte16);

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Input.nomeAtendentes.add(inputNomeAtendentes.getText());
				inputNomeAtendentes.setText("");
				int indexUltimoElemento = Input.nomeAtendentes.size()-1;
				String ultimoNomeAdicionadoArray = Input.nomeAtendentes.get(indexUltimoElemento);
				labelUltimoNomeAdicionado.setText(ultimoNomeAdicionadoArray + " adicionadx com sucesso ao guiche " + indexUltimoElemento);
				nomeAtendentesLabel.setText(labelText + Input.nomeAtendentes.size());
				System.out.println("Nome adicionados: " + Input.nomeAtendentes);
				if (Input.getQuantidadeGuiches() == Input.nomeAtendentes.size()) {
					NomeAtendentes.super.setVisible(false);
					NomeGerente nomeGerente = new NomeGerente();
					nomeGerente.setVisible(true);
				}
			}
		});
	}
}
