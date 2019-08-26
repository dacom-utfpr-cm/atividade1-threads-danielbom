package activity2;

import java.util.Scanner;

/**
 * Classe base para aprender threads. Está classe simplesmente pede por um
 * número para o usuário da quantidade de termos a serem somados, e então recebe
 * os valores do usuário também.
 * 
 * @author daniel
 *
 */
public class Accountant implements Runnable {

	private int sum;

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Informe a quantidade de números a ser somado: ");
		int n = scanner.nextInt();

		System.out.println("Digite os número a serem somados.");

		for (int i = 0; i < n; i++) {
			System.out.printf("[%d]: ", i + 1);
			this.setSum(this.getSum() + scanner.nextInt());
		}

		scanner.close();
	}

	public int getSum() {
		return sum;
	}

	private void setSum(int sum) {
		this.sum = sum;
	}

}