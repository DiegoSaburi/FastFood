package Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que serve como uma
 * extensão do Scanner(que não
 * pode ser herdado)
 */
public class Console {
	Scanner sc;

	public Console() {
		this.sc = new Scanner(System.in);
	}


	public ArrayList <String> stringArrayList (int size){
		ArrayList <String> stringArrayList = new ArrayList<>();
		for (int i = 0 ; i < size ; i++){
			System.out.printf(i+ 1 + "- ");
			stringArrayList.add(sc.next());
		}
		return stringArrayList;
	}

	/**
	 * Limpa o terminal
	 */
	public void clear(){
		//se o sistema for windows
		if (System.getProperty("os.name").contains("Windows")) {
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
		//se o sistema for diferente do windows
		else {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Lê a entrada do usuário e verifica se o numero é inteiro e positivo
	 * @return Primeiro inteiro positivo válido
	 */
	public int inputInteiroPositivo(){
		int inteiroPositivo;

		//se o numero não for inteiro não sai do loop
		do{
			try{
				inteiroPositivo = sc.nextInt();
			}catch (InputMismatchException e){
				System.out.println("Entrada recebida nao e inteiro");
				sc.next();
				continue;
			}
			//se o numero for menor ou igual a 0 não sai do loop
			if (inteiroPositivo <= 0){
				System.out.println("Entrada deve ser um numero positivo");
				continue;
			}
			return inteiroPositivo;
		}while(true);
	}
}
