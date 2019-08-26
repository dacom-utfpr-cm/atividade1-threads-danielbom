package activity2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderLines implements Runnable {

	private String filepath;

	public ReaderLines(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void run() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(this.filepath));

			while (true) {
				for (String line : lines) {
					System.out.printf(line + "\n\n");
					Thread.sleep(10_000);
				}

				if (Thread.interrupted())
					break;
			}
		} catch (InterruptedException ie) {
			System.out.println("Interrupted Exception ocurred.");
		} catch (IOException ioe) {
			System.out.println("IO Exception occurred.");
		}
	}

}
