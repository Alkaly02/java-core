package main;

import javax.swing.*;

public class MainActivity {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("User");
		label.setBounds(10,20,80,25);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100,20,200,25);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 60, 80, 25);
		panel.add(passwordLabel);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(100, 60, 200, 25);
		panel.add(passwordField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(10, 100, 100, 25);
		panel.add(loginBtn);
		
		
		panel.add(label);
		panel.add(userText);
		
		frame.add(panel);
		
		
		frame.setVisible(true);
		

	}

}
