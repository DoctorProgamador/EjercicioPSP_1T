package view;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import control.Listener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class VPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static final int ANCHO = 500;
	public static final int ALTO = 400;
	private JButton btnExcel;
	private JButton btnWord;
	private JButton btnPowerPoint;
	private JButton btnNavegar;
	private JTextField txtUrl;
	private JList<String> listHistorial;
	private DefaultListModel<String> listModel;
	
	public VPrincipal() {
		init();
	}
	 private void init() {
		 getContentPane().setLayout(null);
			
		btnExcel = new JButton("EXCEL");
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(57, 25, 95, 28);
		getContentPane().add(btnExcel);
			
		btnWord = new JButton("WORD");
		btnWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWord.setBounds(162, 25, 97, 28);
		getContentPane().add(btnWord);
			
		btnPowerPoint = new JButton("POWER P.");
		btnPowerPoint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPowerPoint.setBounds(269, 25, 97, 28);
		getContentPane().add(btnPowerPoint);
			
		txtUrl = new JTextField();
		txtUrl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUrl.setText("https://www.");
		txtUrl.setBounds(57, 79, 202, 19);
		getContentPane().add(txtUrl);
		txtUrl.setColumns(10);
			
		btnNavegar = new JButton("NAVEGAR");
		btnNavegar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNavegar.setBounds(269, 72, 97, 28);
		getContentPane().add(btnNavegar);
			
		JScrollPane scrpHistorial = new JScrollPane();
		scrpHistorial.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpHistorial.setBounds(57, 124, 309, 117);
		getContentPane().add(scrpHistorial);
		
		listHistorial = new JList<String>();
		listHistorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel = new DefaultListModel<String>();	
		
		cargarModel();
		
		scrpHistorial.setViewportView(listHistorial);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	 
	private void cargarModel() {
		try (BufferedReader br = new BufferedReader(new FileReader("Ficheros/historial.txt"))) {
	           String linea;
	           
	           while ((linea = br.readLine()) != null) {
	               listModel.addElement(linea);
	           }
	           
	           listHistorial.setModel(listModel);
	       } catch (IOException e) {
	            e.printStackTrace();
	       }
	}
	 
	public void guardarFichero() {
		String url = txtUrl.getText();
		 
		if (!listModel.contains(url)) {
			listModel.addElement(url);
			
			listHistorial.setModel(listModel);

			try (FileWriter fw = new FileWriter("Ficheros/historial.txt", true);){
				fw.write("\n" + url);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        }	
	}
	
	public String getURL() {
		return txtUrl.getText();
	}
	
	public JList<String> getList() {
        return listHistorial;
    }
	
	private void centrarVentana() {      
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                     
		Dimension ventana = new Dimension(ANCHO, ALTO);                     
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void setListener(Listener l) {
		btnExcel.addActionListener(l);
		btnNavegar.addActionListener(l);
		btnPowerPoint.addActionListener(l);
		btnWord.addActionListener(l);
		listHistorial.addMouseListener(l);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
