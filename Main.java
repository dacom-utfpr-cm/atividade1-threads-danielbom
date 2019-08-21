package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static class Sleeper implements Runnable {
		@Override
		public void run() {
			try {

				long id = Thread.currentThread().getId();
				int time = new Random().nextInt(4000) + 1000; // In seconds

				Thread.sleep(time);
				System.out.printf("Thread (%d) sleep by %d time.\n", id, time);

			} catch (InterruptedException e) {
				System.out.println("Eu quero dormir ...!!!");
				System.out.println("Fiz vestibular, estudei muito.");
				System.out.println("Agora me deixa em paz!\n");
			}
		}
	}

	/**
	 * 1. Faça um programa em Java que inicie três threads e, cada thread, espere um
	 * tempo aleatório para terminar.
	 */
	static void exercise1() {
		for (int i = 0; i < 3; i++) {
			new Thread(new Sleeper()).start();
		}
	}

	private static class ReaderLines implements Runnable {

		private String filename;

		public ReaderLines(String filename) {
			this.filename = filename;
		}

		@Override
		public void run() {
			try {
				File file = new File(this.filename);

				while (true) {
					Scanner scanner = new Scanner(file);

					while (scanner.hasNextLine()) {
						System.out.printf(scanner.nextLine() + "\n\n");
						Thread.sleep(10_000);
					}

					if (Thread.interrupted()) {
						scanner.close();
						break;
					}
				}
			} catch (FileNotFoundException | InterruptedException e) {

			}
		}

	}

	/**
	 * 2. Faça uma thread Java que realize a leitura de um arquivo texto com frases
	 * e exiba as frases a cada 10 segundos.
	 */
	static void exercise2() {
		new Thread(new ReaderLines("/home/daniel/phrases.txt")).start();
	}

	/**
	 * 3. Faça um programa Java que envia interrupções para as threads dos
	 * exercı́cios anteriores. As threads devem fazer o tratamento dessas
	 * interrupções e realizar uma finalização limpa.
	 * 
	 * @throws InterruptedException
	 */
	static void exercise3() {
		Thread readerLines = new Thread(new ReaderLines("/home/daniel/phrases.txt"));
		Thread sleeper = new Thread(new Sleeper());

		sleeper.start();
		sleeper.interrupt();

		try {
			readerLines.start();
			Thread.sleep(15000);
			readerLines.interrupt();
		} catch (InterruptedException e) {
			System.out.println("... Você tem demência?");
		}

	}

	private static class InterruptionMonitor extends ArrayList<Thread> implements Runnable {

		@Override
		public void run() {
			while(!this.isEmpty()) {
				this.forEach(thread -> {
					if (thread.isInterrupted())
						System.out.printf("Thread %d foi interrompida!\n", thread.getId());
				});
				this.removeIf(thread -> {
					return !thread.isAlive();
				});
			}
		}
		
	}
	/**
	 * 4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads
	 * receberam sinais de interrupção.
	 */
	static void exercise4() {
		InterruptionMonitor monitor = new InterruptionMonitor();
		Thread readerLines = new Thread(new ReaderLines("/home/daniel/phrases.txt"));
		Thread sleeper = new Thread(new Sleeper());
		
		monitor.add(readerLines);
		monitor.add(sleeper);
		new Thread(monitor).start();
		
		readerLines.start();
		sleeper.start();
		
		sleeper.interrupt();
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) { }
		readerLines.interrupt();		
	}

	public static class Accountant implements Runnable {

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

	/**
	 * Faça uma thread Java que fica aguardando uma sequência numérica de tamanho
	 * arbitrário digitado por usuário para realizar uma soma. Use o join().
	 */
	static void exercise5() {
		try {
			Accountant accountant = new Accountant();
			Thread thread = new Thread(accountant);
			thread.start();
			thread.join();
			System.out.println("O resultado da soma é: " + accountant.getSum());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		exercise4();
		System.out.println("Fim da execução.");
	}
}
