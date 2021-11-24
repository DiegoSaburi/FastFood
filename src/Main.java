import FastFood.Restaurante;
import Interface.FastFoodInterface;
import Utils.Console;
import Utils.Input;

public class Main {

	public static void main(String[] args) {
		Restaurante titan = new Restaurante("TITAN", "0100103");
		Input input = new Input();
		FastFoodInterface fastFoodInterface = new FastFoodInterface("Fast-Food Titanico",input);
		fastFoodInterface.setVisible(true);
	}

}
