package multiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class ProcesoPadre {

	public static void main(String[] args) {
		try {
			Process hijo = new ProcessBuilder("java", "-jar", "C:\\Prueba\\ProcesoHijo.jar").start();
		
			Scanner in = new Scanner(System.in);
			
			//Obtenemos la entrada estándar del proceso hijo (stdin)
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			
			//Obtenemos la salida estándar del proceso hijo (stdout)
			//OutputStream os = hijo.getOutputStream();
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			
			String cadena = "";
			
			while (!cadena.equalsIgnoreCase("fin")) {
				//Lectura de la cadena de caracteres por teclado
				System.out.println("Introduzca una cadena de caracateres: ");
				cadena = in.nextLine();
				
				//Se envía la cadena al proceso hijo
				ps.println(cadena);
				//bw.write(cadena);
				//bw.newLine();
				
				//Volcado de toda la información
				ps.flush();
				//bw.flush();
				
				//Lectura de la salida del proceso hijo
				System.out.println(br.readLine());
			}
			
			System.out.println("Proceso finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
