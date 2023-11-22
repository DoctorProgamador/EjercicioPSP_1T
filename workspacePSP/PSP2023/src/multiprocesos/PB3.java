package multiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PB3 {

	public static void main(String[] args) {
		
		if (args.length <= 0) {
			System.out.println("No tenemos argumentos");
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println("Argumento: " + (i + 1) + ": " + args[i]);
			}
		}
		
		ProcessBuilder test = new ProcessBuilder();
		
		test = new ProcessBuilder("java", "Un saludo", "\"Hola a tod@s!!!\"", "\n");
		
		//Capturar las variables de entorno del sistema (windows)
		//Las almacena en una estructura como par clave/valor y
		//la escribe por consola
		Map entorno = test.environment();
		System.out.println("\nVARIABLES DE ENTORNO");
		System.out.println("====================");
		System.out.println(entorno);
		
		//Leer el nombre del proceso y sus argumentos
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("\nNOMBRE Y ARGUMENTOS DEL COMANDO");
		System.out.println("===============================");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//Ejecución del comando DIR
		test.command("CMD", "/C", "DIR");
		
		try {
			Process p = test.start();
			//Capturar la salida del proceso para mostrarla por consola
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
