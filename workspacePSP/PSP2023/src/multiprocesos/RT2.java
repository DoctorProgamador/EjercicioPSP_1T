package multiprocesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RT2 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		
		String comando = "CMD /C DIR";
		Process p = null;
		
		try {
			p = r.exec(comando);
			
			//Con el método 'getInputStream()' se lee el stream de la salida
			//del proceso y leemos la salida de la ejecución del comando, para
			//escribirlo por consola
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error en: " + comando);
			//e.printStackTrace();
		}
	}
}
