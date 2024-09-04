package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import models.Student;

class StudentFrame extends JFrame{
	public JTextField nomTextField;
	public JTextField ageTextField;
	JTable studentsTable;
	DefaultTableModel tableModel;
	
	@Override
	public Insets getInsets() {
		return new Insets(10, 10, 10, 10);
	}
	
	public StudentFrame() {
//		Connexion a la base de donnees
		Student.connectDb();
//		Demarrage du frame
		setTitle("Gestion d'eleves");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel formPanel = new JPanel(new GridLayout(4, 6));
		
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
		
		JButton searchBtn = new JButton("Rechercher");
		formPanel.add(searchBtn);
		
		JButton updateBtn = new JButton("Mettre a jour");
		formPanel.add(updateBtn);
		
		tableModel = new DefaultTableModel(new Object[] {"Nom", "Age"}, 0);
		studentsTable = new JTable(tableModel);
		
		add(new JScrollPane(studentsTable));
		
		submitBtn.addActionListener(new SubmitActionListener());
		searchBtn.addActionListener(new SearchStudentActionListener());
		updateBtn.addActionListener(new UpdateStudentActionListener());
		
//		afficher la liste des eleves au chargement
		this.loadStudentsTable();
		
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
	
//	Recuperer les etudiants et les lister sur une table
	public void loadStudentsTable() {
//		vider le tableau avant de l'afficher a nouveau
		tableModel.setRowCount(0);
		try {
			ResultSet rs = Student.getStudents();
			mapDataToTable(rs);
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la recuperation des students");
			ex.printStackTrace();
		}
	}
//	
	public void mapDataToTable(ResultSet rs) {
		tableModel.setRowCount(0);
		try {
			while(rs.next()) {
				tableModel.addRow(new Object[] {rs.getString("name"), rs.getInt("age")});;
			}
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la recuperation des colonnes");
			ex.printStackTrace();
		}
	}
	
	private class SubmitActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nom = nomTextField.getText();
			String age = ageTextField.getText();
			
			if(nom.isEmpty() || age.isEmpty()) {
				JOptionPane.showMessageDialog(StudentFrame.this, "Les champs ne doivent pas etre vides", "Erreur", JOptionPane.ERROR_MESSAGE);
				return;
			}else {
				Student.createUser(nom, Integer.parseInt(age));
				loadStudentsTable();
				nomTextField.setText("");
				ageTextField.setText("");
			}
		}
	}
	
	private class SearchStudentActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String nameToSearch = nomTextField.getText();
			
			if(nameToSearch.isEmpty()) {
				JOptionPane.showMessageDialog(rootPane, "Veuillez remplir le champ name", "Erreur", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try {
				ResultSet rs = Student.searchStudent(nameToSearch);
				mapDataToTable(rs);
			}catch(SQLException ex) {
				System.out.println("Une erreur est survenue lors de la recherche de " + nameToSearch);
				ex.printStackTrace();
			}
		}
	}
	
	private class UpdateStudentActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nomTextField.getText();
			String age = ageTextField.getText();
			if(name.isEmpty() || age.isEmpty()) {
				JOptionPane.showMessageDialog(rootPane, "Le name et l'age sont obligatioire", "Erreur", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Student.updateStudent(name, Integer.parseInt(age));
			loadStudentsTable();
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
