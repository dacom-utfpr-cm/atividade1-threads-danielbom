package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderLines implements Runnable {

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
