import FastFood.Restaurante;
import Utils.Console;
import Utils.Input;
import Interface.FastFoodInterface;
import Interface.*;

public class Main {

	public static void main(String[] args) {
		Input input = new Input();
		FastFoodInterface fastFoodInterface = new FastFoodInterface("Fast-Food Titanico");
		fastFoodInterface.setVisible(true);
	}
}
