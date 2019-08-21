package activity2;

import java.util.Random;

public class Sleeper implements Runnable {
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
