package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import businessLogic.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Aurkezpena3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private Login negozioLogika;
	private JPasswordField pwdPassword;
	private JButton btnSistemanSartu;
	private JTextArea textArea;
	private DefaultListModel<String> erabiltzaileak = new DefaultListModel<String>();
	private JList<String> list;
	


	/**
	 * Create the frame.
	 */
	public Aurkezpena3() {
		setTitle("Erabilpen kasua: Login egin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setText("login");
		txtLogin.setBounds(233, 23, 134, 28);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblErabiltzaileIzenaSartu = new JLabel("Erabiltzaile izena sartu");
		lblErabiltzaileIzenaSartu.setBounds(50, 29, 165, 16);
		contentPane.add(lblErabiltzaileIzenaSartu);
		
		JLabel lblPasahitzaSartu = new JLabel("Pasahitza sartu");
		lblPasahitzaSartu.setBounds(50, 72, 145, 16);
		contentPane.add(lblPasahitzaSartu);
		
		JLabel lblErabiltzaileMotaAukeratu = new JLabel("Erabiltzaile mota aukeratu");
		lblErabiltzaileMotaAukeratu.setBounds(30, 118, 165, 16);
		contentPane.add(lblErabiltzaileMotaAukeratu);
		
		btnSistemanSartu = new JButton("Sisteman sartu");
		btnSistemanSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String izena=txtLogin.getText();
				String pass=new String(pwdPassword.getPassword());
				String mota=list.getSelectedValue().toString();
				
				boolean b=negozioLogika.loginEgin(izena, pass, mota);
				if (b) textArea.setText("Aurrera");
				else textArea.setText("Errorea");
				 
			}
		});
		btnSistemanSartu.setBounds(178, 158, 117, 29);
		contentPane.add(btnSistemanSartu);
		
		textArea = new JTextArea();
		textArea.setBounds(94, 199, 290, 55);
		contentPane.add(textArea);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setBounds(233, 66, 134, 28);
		contentPane.add(pwdPassword);
		
		list = new JList<String>();
		list.setBounds(246, 118, 117, 37);
		contentPane.add(list);
		list.setModel(erabiltzaileak);
		erabiltzaileak.addElement("ikasle");
		erabiltzaileak.addElement("irakasle");

	}
	public void setNeogozioLogica (Login nl){
		negozioLogika=nl;
	}
}

