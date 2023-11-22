package actividades;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejecuta {

	public static void main(String[] args) {
		
		if (args.length <= 0) {
			System.out.println("No hay argumentos");
		}
		
		ProcessBuilder pb = new ProcessBuilder();
		
		pb.command(args);
		
		try {
			Process p = pb.start();
			
			int retorno = p.waitFor();
			
			if (retorno == 0) {
				
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
				br.close();
				
				System.out.println("\nEl proceso finalizó correctamente");
			} else {
				System.err.println("El proceso hijo finalizo de manera incorrecta");
			}
		
		} catch (Exception e) {
			System.err.println("¡¡ERROR!! La ejecución no se ha realizado correctamente");
			e.printStackTrace();
		}
	}
}
