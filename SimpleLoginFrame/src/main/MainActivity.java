package main;

import javax.swing.*;

public class MainActivity {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		addComponentsToPanel(panel);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	public static void addComponentsToPanel(JPanel panel) {
//		Definition du label du user
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 50, 50);
		panel.add(userLabel);
//		Definition le l'input de type text associer au label user
		JTextField userTextField = new JTextField(20);
		userTextField.setBounds(130, 20, 200, 30);
		panel.add(userTextField);
		
//		Definition du label password
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 100, 50);
		panel.add(passwordLabel);
//		Definition de l'input de type password associe au label password
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setBounds(130, 60, 200, 30);
		panel.add(passwordField);
		
//		Login Btn
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(10, 100, 100, 30);
		panel.add(loginBtn);
		
	}

}
