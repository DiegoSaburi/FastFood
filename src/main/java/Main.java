import FastFood.Restaurante;
import Utils.Console;
import Utils.Input;
import Interface.FastFoodInterface;

public class Main {

	public static void main(String[] args) {
		Restaurante titan = new Restaurante("TITAN", "0100103");
		Input input = new Input();
		FastFoodInterface fastFoodInterface = new FastFoodInterface("Fast-Food Titanico",input);
		fastFoodInterface.setVisible(true);
	}
}
