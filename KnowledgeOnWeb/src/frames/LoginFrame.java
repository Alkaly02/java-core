package frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame implements ActionListener {
	
	JFrame frame = new JFrame("Connexion a KnowledgOnWeb");
	JButton loginButton = new JButton("Connexion");
	JButton resetButton = new JButton("Annuler");
	JTextField userIdField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIdLabel = new JLabel("Email");
	JLabel userPasswordLabel = new JLabel("Mot de passe");
	JLabel messageLabel = new JLabel("");
	
	public LoginFrame(){
		userIdLabel.setBounds(20, 100, 100, 60);
		userPasswordLabel.setBounds(20, 150, 100, 60);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIdField.setBounds(125, 110, 300, 40);
		userPasswordField.setBounds(125, 160, 300, 40);
		
		loginButton.setBounds(120, 220, 150, 40);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(280, 220, 150, 40);
		resetButton.addActionListener(this);
		
		frame.add(userIdLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIdField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(620, 620);
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
//			fermer le frame de connexion
			frame.dispose();
//			ouvrir le frame d'admission
			new AdmissionFrame();
		}
	}	
}