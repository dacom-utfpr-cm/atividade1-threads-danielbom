package ex2;

import java.util.stream.Stream;

/**
 * 1. Faça um programa em Java que inicie três threads e, cada thread, espere um
 * tempo aleatório para terminar.
 * 
 * @author daniel
 */
public class Exercise1 {

	public static void main(String[] args) {
//		for (int i = 0; i < 3; i++) new Thread(new Sleeper()).start();
		
		Stream
			.generate(() -> new Thread(new Sleeper()))
			.limit(3)
			.forEach(thread -> thread.start());
	}

}
