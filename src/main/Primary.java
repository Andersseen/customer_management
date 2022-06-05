package main;

import java.awt.EventQueue;

import conexion.Connect;
import gui.Window;

public class Primary {

	public static void main(String[] args) {
		
		Connect myConnection = new Connect();
		String response = myConnection.conectar();
		System.out.println(response);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
