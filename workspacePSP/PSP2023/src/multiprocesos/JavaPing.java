package multiprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaPing {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		Process process = null;
		
		try {
			process = runtime.exec("ping" + " -t " + "www.google.es");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
			for (int i = 0; i < 10; i++) {
				System.out.println("Saludos --> " + in.readLine());
			}
			
		} catch (IOException e) {
			System.out.println("No se puede ejecutar el comando 'ping'");
			e.printStackTrace();
		}
		
		if (process != null) {
			process.destroy();
		}
		
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Estado de finalización: " + process.exitValue());
	}
}
