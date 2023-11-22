package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Ej2Padre {

	public static void main(String[] args) {
		try {
			Process hijo = new ProcessBuilder("java", "-jar", "C:\\Prueba\\ProcesoHijo2.jar").start();
		
			Scanner sc = new Scanner(System.in);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			
			String cadena = "";

			System.out.println("Introduzca una cadena de caracteres, puede estar formada por letras o números");
			cadena = sc.nextLine();
			
			while (!cadena.equalsIgnoreCase("fin")) {
				ps.println(cadena);
	
				ps.flush();
				
				System.out.println(br.readLine());
				
				System.out.println("Introduzca una cadena de caracteres, puede estar formada por letras o números o FIN si quiere salir del programa");
				cadena = sc.nextLine();
			}
			
			System.out.println("Proceso finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
