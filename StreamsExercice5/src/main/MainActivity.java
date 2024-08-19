package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import models.Student;

public class MainActivity {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))) {
            while (true) {
                try {
                    Student deserializedStudent = (Student) ois.readObject();
                    students.add(deserializedStudent);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
//		for(Student student: students) {
		System.out.println("Student: "+ students.size());
//		}
//		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"))){
//			Student deserializedStudent = (Student) ois.readObject();
//			System.out.println("Student: "+ deserializedStudent.getNom());
//		}catch(IOException | ClassNotFoundException ie) {
//			System.out.println("Veuillez verifier que le fichier student.dat existe");
//			ie.printStackTrace();
//		}
		
//		Creation du cadre(frame)
		JFrame frame = new JFrame("Ajout eleve");
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
				
				Student student = new Student(nom, prenom, (int)Integer.parseInt(age), numero);
				
				try(FileOutputStream fos = new FileOutputStream("student.dat", true)){
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(student);
					oos.close();
					fos.close();
					System.out.println("Etudiant ajoute avec succes");
				}catch(IOException ie) {
					System.out.println("Une erreur est survenue lors de la creation du fichier student.dat");
					ie.printStackTrace();
				}
			}
		});
		
		
		frame.add(panel);
		
		frame.setVisible(true);
	}

}
