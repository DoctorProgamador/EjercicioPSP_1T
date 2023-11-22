package main;

import java.awt.EventQueue;

import control.Listener;
import view.VPrincipal;

public class GestorProgramas {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VPrincipal v = new VPrincipal();
				
				Listener l = new Listener(v);
				
				v.setListener(l);
				
				v.hacerVisible();		
			}
		});

	}
}
