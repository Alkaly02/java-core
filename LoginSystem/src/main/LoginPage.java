package main;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIdField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIdLabel = new JLabel("User id");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel("");
	
	HashMap<String, String> loginInfoOriginal = new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal){
		this.loginInfoOriginal = loginInfoOriginal;
		
		userIdLabel.setBounds(50, 100, 75, 50);
		userPasswordLabel.setBounds(50, 150, 75, 50);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIdField.setBounds(125, 110, 200, 25);
		userPasswordField.setBounds(125, 160, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		
		frame.add(userIdLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIdField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			userIdField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginButton) {
			String userId = userIdField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
		}
	}	
}
