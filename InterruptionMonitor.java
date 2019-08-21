package ex2;

import java.util.ArrayList;

public class InterruptionMonitor  extends ArrayList<Thread> implements Runnable {

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
