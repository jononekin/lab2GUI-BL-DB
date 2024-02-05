package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

import businessLogic.Login;
import businessLogic.Login1;
import businessLogic.Login3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Aurkezpena extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private  ButtonGroup buttonGroup = new ButtonGroup();
	private Login negozioLogika;
	private JPasswordField pwdPassword;
	private JButton btnSistemanSartu;
	private JTextArea textArea;
	private JRadioButton rdbtnIrakaslea;
	private JRadioButton rdbtnIkaslea;

	

	/**
	 * Create the frame.
	 */
	public Aurkezpena() {
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
				String mota="";
				if (rdbtnIrakaslea.isSelected())
					mota=rdbtnIrakaslea.getText();
				else
					if (rdbtnIkaslea.isSelected())
						mota= rdbtnIkaslea.getText();
				
				boolean b=negozioLogika.loginEgin(izena, pass, mota);
				if (b) textArea.setText("Aurrera");
				else textArea.setText("Errorea");
				
			}
		});
		btnSistemanSartu.setBounds(178, 159, 117, 29);
		contentPane.add(btnSistemanSartu);
		
		textArea = new JTextArea();
		textArea.setBounds(94, 199, 290, 55);
		contentPane.add(textArea);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setBounds(233, 66, 134, 28);
		contentPane.add(pwdPassword);
		
		rdbtnIrakaslea = new JRadioButton("irakasle");
		buttonGroup.add(rdbtnIrakaslea);
		rdbtnIrakaslea.setBounds(207, 114, 88, 23);
		contentPane.add(rdbtnIrakaslea);
		
		rdbtnIkaslea = new JRadioButton("ikasle");
		buttonGroup.add(rdbtnIkaslea);
		rdbtnIkaslea.setBounds(299, 114, 85, 23);
		contentPane.add(rdbtnIkaslea);
	}
	public void setNeogozioLogica (Login nl){
		negozioLogika=nl;
	}
}
