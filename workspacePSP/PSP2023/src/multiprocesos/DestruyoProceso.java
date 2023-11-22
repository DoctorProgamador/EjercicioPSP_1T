package multiprocesos;

public class DestruyoProceso {

	public static void main(String[] args) {
		try {
			Process miProceso = new ProcessBuilder("C:\\Users\\nacho\\AppData\\Local\\Programs\\Microsoft VS Code\\Code.exe").start();
			Thread.sleep(10000);
			System.out.println("Destruyendo proceso...");
			miProceso.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
