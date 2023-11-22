package ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Ej1Hijo {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		String cadena = sc.nextLine();
		
		int numAlea;
		while (cadena != null) {
			numAlea = rd.nextInt(11);
			System.out.println(numAlea);
			cadena = sc.nextLine();
		}
		
		
	}
}
