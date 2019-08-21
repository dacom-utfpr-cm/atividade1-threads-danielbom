package activity2;

/**
 * 3. Faça um programa Java que envia interrupções para as threads dos
 * exercı́cios anteriores. As threads devem fazer o tratamento dessas
 * interrupções e realizar uma finalização limpa.
 * 
 * @author daniel
 * 
 */
public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {
		Thread readerLines = new Thread(new ReaderLines("/home/daniel/phrases.txt"));
		Thread sleeper = new Thread(new Sleeper());

		sleeper.start();
		sleeper.interrupt();

		readerLines.start();
		Thread.sleep(15000);
		readerLines.interrupt();
	}

}
