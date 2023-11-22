package multiprocesos;

import java.util.Scanner;

public class ProcesoHijo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cadena = sc.nextLine();
		
		while (cadena != null) {
			System.out.println("Proceso Hijo: " + cadena.toUpperCase());
			cadena = sc.nextLine();
		}
		
		sc.close();
	}
}
