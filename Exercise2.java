package activity2;

/**
 * 2. Faça uma thread Java que realize a leitura de um arquivo texto com frases
 * e exiba as frases a cada 10 segundos.
 * 
 * @author daniel
 */
public class Exercise2 {
	public static void main(String[] args) {
		new Thread(new ReaderLines("/home/daniel/phrases.txt")).start();
	}
}
