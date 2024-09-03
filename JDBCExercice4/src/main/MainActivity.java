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
		Student.connectDb();
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
		
		tableModel = new DefaultTableModel(new Object[] {"Nom", "Age"}, 0);
		studentsTable = new JTable(tableModel);
		
		add(new JScrollPane(studentsTable));
		
		submitBtn.addActionListener(new SubmitActionListener());
		
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
			while(rs.next()) {
				System.out.println(rs.getString("name"));
				tableModel.addRow(new Object[] {rs.getString("name"), rs.getInt("age")});;
			}
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la recuperation des students");
			ex.printStackTrace();
		}
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
				Student.createUser(nom, Integer.parseInt(age));
				loadStudentsTable();
			}
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
