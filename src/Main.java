import FastFood.Restaurante;
import Utils.Console;
import Utils.Input;

public class Main {

	public static void main(String[] args) {
		Restaurante titan = new Restaurante("TITAN", "0100103");
		Input input = new Input();
		Console console = new Console();

		System.out.println("Digite a quantidade de guiches do fast-food");
		input.setQuantidadeGuiches(console.inputInteiroPositivo());
		console.clear();
		System.out.println("Digite o nome dos atendentes dos guiches");
		input.setNomeAtendentes(console.stringArrayList(input.getQuantidadeGuiches()));
	}

}
