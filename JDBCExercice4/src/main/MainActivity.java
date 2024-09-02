package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

class StudentFrame extends JFrame{
	public JTextField nomTextField;
	public JTextField ageTextField;
	
	@Override
	public Insets getInsets() {
		return new Insets(10, 10, 10, 10);
	}
	
	public StudentFrame() {
		Students.connectDb();
		setTitle("Gestion d'eleves");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel formPanel = new JPanel(new GridLayout(2, 4));
		
//		Border padding = Bord
		
		JLabel nomLabel = new JLabel("Nom");
		nomTextField = new JTextField();
//		this.setNomTextField(new JTextField());
		formPanel.add(nomLabel);
		formPanel.add(nomTextField);
		
		JLabel ageLabel = new JLabel("Age");
		ageTextField = new JTextField();
//		this.setAgeTextField(new JTextField());
		formPanel.add(ageLabel);
		formPanel.add(ageTextField);
		
		JButton submitBtn = new JButton("Ajouter");
		formPanel.add(submitBtn);
		
		submitBtn.addActionListener(new SubmitActionListener());
		
		add(formPanel, BorderLayout.NORTH);
		setVisible(true);
	}
	
	public void setNomTextField(JTextField nomTextField) {
		this.nomTextField = nomTextField;
	}
	public JTextField gettNomTextField() {
		return this.nomTextField;
	}
	
	public void setAgeTextField(JTextField ageTextField) {
		this.ageTextField = ageTextField;
	}
	public JTextField getAgeTextField() {
		return this.ageTextField;
	}
	
	private class SubmitActionListener implements ActionListener{
//		private static final long serialVersionUID = 1L;
		public void actionPerformed(ActionEvent e) {
			String nom = nomTextField.getText();
			String age = ageTextField.getText();
			
			if(nom.isEmpty() || age.isEmpty()) {
				JOptionPane.showMessageDialog(StudentFrame.this, "Les champs ne doivent pas etre vides", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				Students.createUser(nom, Integer.parseInt(age));
			}
		}
	}
}

class Students{
	public static Connection con;
	private static void loadDriver() {
		try {
			Class.forName("com.mySql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Une erreur est survenue lors du chargement du driver");
			ex.printStackTrace();
		}
	}
	public static void connectDb() {
		loadDriver();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la connexion a la base de donnees");
			ex.printStackTrace();
		}
	}
	
	public static void createUser(String nom, int age) {
		String query = "INSERT INTO students (name, age) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, nom);
			preparedStatement.setInt(2, age);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println(nom + " a ete ajoute avec succes");
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la creation de " + nom);
			ex.printStackTrace();
		}
	}
}

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SwingUtilities.invokeLater(() -> new StudentFrame());
		new StudentFrame();
	}

}
