package ejercicio2;

import java.util.Scanner;

public class Ej2Hijo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String cadena = sc.nextLine();
	
        while (cadena != null) {
        	StringBuilder sb = new StringBuilder(cadena);
            String cadAlReves = sb.reverse().toString();
        	
			if (cadena.equalsIgnoreCase(cadAlReves)) {
				System.out.println(cadena + " es un palíndromo");
				cadena = sc.nextLine();
			} else {
				System.out.println(cadena + " no es un palíndromo");
				cadena = sc.nextLine();
			} 
		}
	}
}
