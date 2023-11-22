package multiprocesos;

import java.io.IOException;

public class PB1 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("Notepad");
		//ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "dir c:");
		
		try {
			Process p = pb.start();
			//Process p2 = pb.start
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
