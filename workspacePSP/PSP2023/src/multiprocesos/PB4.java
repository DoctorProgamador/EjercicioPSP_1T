package multiprocesos;

import java.io.File;
import java.io.IOException;

public class PB4 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
		
		//Declaración de los descriptores de los ficheros donde vamos a
		//redireccionar cada salida del proceso
		//éstandar --> stdout || errores --> stderr
		File fOut = new File("C:\\Prueba\\salida.txt");
		File fErr = new File("C:\\Prueba\\error.txt");
		
		pb.redirectError(fErr);
		pb.redirectOutput(fOut);
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
