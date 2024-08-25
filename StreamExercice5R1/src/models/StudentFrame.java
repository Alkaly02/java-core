package models;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame {
	public void showFrame() {
		this.setSize(600, 700);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		JPanel formPabel = new JPanel(new GridLayout(5, 2, 20, 20));
//		prenom
		JLabel prenomLabel = new JLabel("Prenom");
		JTextField prenomTextField = new JTextField();
		formPabel.add(prenomLabel);
		formPabel.add(prenomTextField);
//		nom
		JLabel nomLabel = new JLabel("Nom");
		JTextField nomTextField = new JTextField();
		formPabel.add(nomLabel);
		formPabel.add(nomTextField);
//		age
		JLabel ageLabel = new JLabel("Age");
		JTextField ageTextField = new JTextField();
		formPabel.add(ageLabel);
		formPabel.add(ageTextField);
//		numeroEtudiant
		JLabel numeroLabel = new JLabel("Numero");
		JTextField numeroTextField = new JTextField();
		formPabel.add(numeroLabel);
		formPabel.add(numeroTextField);
		
		JButton submitBtn = new JButton("Ajouter");
		formPabel.add(submitBtn);
	
		this.handleSubmitForm(submitBtn, prenomTextField, nomTextField, ageTextField, numeroTextField);
//		Afficher le tableau des etudiants
		this.displayStudents();
//		
		this.add(formPabel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	private void handleSubmitForm(JButton submitBtn,JTextField prenomTextField, JTextField nomTextField, JTextField ageTextField, JTextField numeroTextField) {
		submitBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String prenom = prenomTextField.getText();
				String nom = nomTextField.getText();
				String age = ageTextField.getText(); 
				String numeroEtudiant = numeroTextField.getText();
				System.out.println(prenom + ", " + nom + ", " + age + ", " + numeroEtudiant);
				if(prenom.isEmpty() || nom.isEmpty() || age.isEmpty() || numeroEtudiant.isEmpty()) {
//					StudentFrame.this nous permet d'acceder au frame, le this seulement fait reference a new ActionListener()
					JOptionPane.showMessageDialog(StudentFrame.this, "Tous les champs sont obligatoires", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Student student = new Student(nom, prenom, Integer.parseInt(age), numeroEtudiant);
				student.saveStudents();
				StudentFrame.this.displayStudents();
				prenomTextField.setText("");
				nomTextField.setText("");
				ageTextField.setText("");
				numeroTextField.setText("");
			}
		});
	}
	
	public void displayStudents() {
		ArrayList<Student> students = Student.getAllStudents();
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Nom", "Prenom", "Age", "Numero Etudiant"}, 0);
		JTable table = new JTable(tableModel);
		for(Student student:students) {
			tableModel.addRow(new Object[] {student.getNom(), student.getPrenom(), student.getAge(), student.getNumeroEtudiant()});
		}
		this.add(table);
	}
}
