package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JList;

import view.VPrincipal;

public class Listener extends MouseAdapter implements ActionListener{

	private VPrincipal ventana;
	
	public Listener(VPrincipal ventana) {
		super();
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ruta;
		
		if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals("EXCEL")) {
				ruta = "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE";
				abrirPrograma(ruta);
			} else if (e.getActionCommand().equals("WORD")) {
				ruta = "C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE";	
				abrirPrograma(ruta);
			} else if (e.getActionCommand().equals("POWER P.")) {
				ruta = "C:\\Program Files\\Microsoft Office\\root\\Office16\\POWERPNT.EXE";
				abrirPrograma(ruta);
			} else if (e.getActionCommand().equals("NAVEGAR")){
				navegar();
				
				ventana.guardarFichero();
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
        JList<String> list = ventana.getList();
        
        if (e.getClickCount() == 1) {
            int index = list.locationToIndex(e.getPoint());
            try {
                String url = ventana.getList().getModel().getElementAt(index);
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

	private void navegar() {
		 try {
             String url = ventana.getURL();
             Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
	}

	private void abrirPrograma(String ruta) {
		ProcessBuilder pb = new ProcessBuilder(ruta);
		try {
			Process p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
