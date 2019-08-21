package ex2;

/**
 * 4. Faça uma Thread que monitora um conjunto de threads e exiba quais threads
 * receberam sinais de interrupção.
 */
public class Exercise4 {

	public static void main(String[] args) throws InterruptedException {
		InterruptionMonitor monitor = new InterruptionMonitor();
		Thread readerLines = new Thread(new ReaderLines("/home/daniel/phrases.txt"));
		Thread sleeper = new Thread(new Sleeper());

		monitor.put(readerLines, sleeper);
		new Thread(monitor).start();

		readerLines.start();
		sleeper.start();

		sleeper.interrupt();
		Thread.sleep(11000);
		readerLines.interrupt();
	}

}
