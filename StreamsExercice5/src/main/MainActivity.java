package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import models.Student;

public class MainActivity {
//https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static ArrayList<Student> studentsLoaded = new ArrayList<Student>();
	static JFrame frame = new JFrame("Ajout eleve");
	
	public static void main(String[] args) {
		showStudents();
		
//		Creation du cadre(frame)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
		JPanel panel = new JPanel(new GridLayout(3, 2));
		
////		prenom
		JTextField prenomTextField = new JTextField(15);
		panel.add(prenomTextField);
////		nom
		JTextField nomTextField = new JTextField(15);
		panel.add(nomTextField);
////		age
		JTextField ageTextField = new JTextField(5);
		panel.add(ageTextField);
////		numero
		JTextField numeroTextField = new JTextField(15);
		panel.add(numeroTextField);
////		button
		JButton submitBtn = new JButton("Ajouter");
		panel.add(submitBtn);
//		gestion de la soumission
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
				students.add(student);
				System.out.println("Etudiant ajoute avec succes");
//				Sauvegarder un etudiant
				saveStudents();
				showStudents();
			}
		});
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	public static void saveStudents() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"))){
			for(Student student: students) {
				oos.writeObject(student);
			}
			oos.close();
		}catch(IOException ie) {
			System.out.println("Une erreur est survenue lors de la creation du fichier student.dat");
			ie.printStackTrace();
		}
	}
	
	public static void showStudents() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))){
			while(true) {
				try {
					Student deserializedStudent = (Student) ois.readObject();
					studentsLoaded.add(deserializedStudent);				}
				catch(ClassNotFoundException ie) {
					System.out.println("EOF");
					break;
				}
				
			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		String[] tableColumns = {"Prenom", "Nom", "Age", "Numero"};
		
		DefaultTableModel tableModel = new DefaultTableModel(tableColumns, 0);
		
		for(Student student: students) {
			Object[] row = {student.getPrenom(), student.getNom(), student.getAge(), student.getNumeroEtudiant()};
			tableModel.addColumn(row);
		}
		
		JTable table = new JTable(tableModel);
		
		JPanel panel = new JPanel();
		
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		frame.add(panel);
		
		for(Student student: studentsLoaded) {
			System.out.println(student.getPrenom());
		}
	}

}
