package multiprocesos;

import java.io.File;
import java.io.IOException;

public class PB5 {

	public static void main(String[] args) {
		//Creación de un fichero dentro del directorio C:/Prueba
		//con algunos comandos de línea de comandos de Windows.
		//El fichero se va a llamar 'fichero.bat' con el siguiente contenido:
		//mkdir c:\Prueba\NUEVO
		//cd c:\Prueba\NUEVO
		//echo CREACIÓN FICHERO>\Prueba\NUEVO\MiFichero.txt
		//echo FICHERO CREADO!!!
		//dir c:\Prueba
		//dirr c:\Prueba
		//echo FIN EJECUCIÓN COMANDOS!!!
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		//Descriptores de los ficheros: Salida, Errores y Entrada
		File fOut = new File("C:\\Prueba\\salida.txt");
		File fErr = new File("C:\\Prueba\\error.txt");
		File fBat = new File("C:\\Prueba\\fichero.bat");
		
		//Redireccionar las salidas y entrada estándar
		pb.redirectError(fErr);
		pb.redirectOutput(fOut);
		pb.redirectInput(fBat);
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
