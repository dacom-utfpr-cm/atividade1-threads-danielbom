package activity2;

import java.util.ArrayList;

/**
 * Classe monitora de threads que alerta caso uma thread esteja em estado de
 * interrupção.
 * 
 * @author daniel
 *
 */
public class InterruptionMonitor implements Runnable {

	private ArrayList<Thread> threads;

	public InterruptionMonitor() {
		this.threads = new ArrayList<Thread>();
	}

	public InterruptionMonitor put(Thread... threads) {
		for (Thread t : threads)
			this.threads.add(t);
		return this;
	}

	private void alert(Thread t) {
		if (t.isInterrupted())
			System.out.printf("Thread %d recebeu um sinal de interrupção!\n", t.getId());
	}

	@Override
	public void run() {
		while (!this.threads.isEmpty()) {
			this.threads.forEach(this::alert);
			this.threads.removeIf(thread -> !thread.isAlive());
		}
	}

}
