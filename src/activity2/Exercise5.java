package activity2;

/**
 * Faça uma thread Java que fica aguardando uma sequência numérica de tamanho
 * arbitrário digitado por usuário para realizar uma soma. Use o join().
 * 
 * @author daniel
 * 
 */
public class Exercise5 {

	public static void main(String[] args) throws InterruptedException {
		Accountant accountant = new Accountant();
		Thread thread = new Thread(accountant);
		thread.start();
		thread.join();
		System.out.println("O resultado da soma é: " + accountant.getSum());
	}

}
