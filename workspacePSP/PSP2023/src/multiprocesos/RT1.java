package multiprocesos;

import java.io.IOException;

public class RT1 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		
		String comando = "NOTEPAD.exe";
		Process p;
		
		try {
			p = r.exec(comando);
		} catch (IOException e) {
			System.out.println("Error en: " + comando);
			//e.printStackTrace();
		}
	}
}
