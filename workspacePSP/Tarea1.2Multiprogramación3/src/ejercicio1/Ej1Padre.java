package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Ej1Padre {
	public static void main(String[] args) {
		try {
			Process hijo = new ProcessBuilder("java", "-jar", "C:\\Prueba\\ProcesoHijo1.jar").start();
		
			Scanner sc = new Scanner(System.in);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			
			String cadena = "";

			cadena = sc.nextLine();
			
			while (!cadena.equalsIgnoreCase("fin")) {
				ps.println(cadena);
	
				ps.flush();
				
				System.out.println(br.readLine());
				
				cadena = sc.nextLine();
			}
			
			System.out.println("Proceso finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
