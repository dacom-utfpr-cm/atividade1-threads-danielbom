package ex2;

/**
 * 4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads
 * receberam sinais de interrupção.
 */
public class Exercise4 {

	public static void main(String[] args) {
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
		} catch (InterruptedException e) {
		}
		readerLines.interrupt();
	}

}
