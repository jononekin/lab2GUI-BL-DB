package gui;

import java.awt.EventQueue;

import businessLogic.Login;
import businessLogic.Login3;

public class Launcher {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aurkezpena2 frame = new Aurkezpena2();
					Login nl=new Login3();
					frame.setNeogozioLogica(nl);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
