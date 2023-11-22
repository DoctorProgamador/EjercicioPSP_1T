package multiprocesos;

import java.io.IOException;
import java.io.InputStream;

public class PB2 {

	public static void main(String[] args) {
		try {
			Process p = new ProcessBuilder("cmd", "/c", "dir c:").start();
			
			//Método getInputStream() de la clase Process para leer el stream de salida
			//del proceso y poder escribirla por consola
			InputStream is = p.getInputStream();
			
			//Muestra por pantalla caracter a caracter la salida del proceso
			
			int c;
			while ((c = is.read()) != -1) {
				System.out.println((char) c);
			}
			is.close();
			
			//Comprobación de finalización del proceso hijo
			// Con el método 'waitFor()', de la clase Process, ponemos en espera el proceso
			//padre para comprobar la finalización del proceso hijo
			//Bien --> 0 ; Mal --> 1
			int exitVal;
			try {
				exitVal = p.waitFor();
				System.out.println("\nValor de salida: " + exitVal);
				if (exitVal != 0) {
					System.out.println("Error en la ejecución del comando");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
