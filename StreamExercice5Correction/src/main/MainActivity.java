package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Student;

public class MainActivity {
	
	static ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ajout etudiant");
		frame.setSize(900, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
//		prenom
		JLabel prenomLabel = new JLabel("Prenom");
		JTextField prenomTextField = new JTextField();
		panel.add(prenomLabel);
		panel.add(prenomTextField);
//		nom
		JLabel nomLabel = new JLabel("Nom");
		JTextField nomTextField = new JTextField();
		panel.add(nomLabel);
		panel.add(nomTextField);
//		age
		JLabel ageLabel = new JLabel("Age");
		JTextField ageTextField = new JTextField();
		panel.add(ageLabel);
		panel.add(ageTextField);
//		numeroEtudiant
		JLabel numeroLabel = new JLabel("Numero");
		JTextField numeroTextField = new JTextField();
		panel.add(numeroLabel);
		panel.add(numeroTextField);
//		Button
		JButton submitBtn = new JButton("Ajouter");
		panel.add(submitBtn);
		
		DefaultTableModel tableColumns = new DefaultTableModel(new Object[] {"Prenom", "Nom", "Age", "Numero"}, 0);
		
		JTable table = new JTable(tableColumns);
		
		ArrayList<Student> savedStudents = (ArrayList<Student>) Student.getAllStudents();
		for(Student savedStudent : savedStudents) {
			tableColumns.addRow(new Object[]  {savedStudent.getPrenom(), savedStudent.getNom(), savedStudent.getAge(), savedStudent.getNumeroEtudiant()});
//			System.out.println(savedStudent.getPrenom());
		}
		
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String prenom = prenomTextField.getText();
				String nom = nomTextField.getText();
				String age = ageTextField.getText();
				String numero = numeroTextField.getText();
				
				if(prenom.isEmpty() || nom.isEmpty() || age.isEmpty() || numero.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Student student = new Student(nom, prenom, Integer.parseInt(age), numero);
				
				student.saveStudents();			
				
//				students.add(student);
				
				
			}
		});
		
		
		
		
		frame.add(table);
		frame.add(panel, BorderLayout.NORTH);
		frame.setVisible(true);

	}

}
