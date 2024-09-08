package main;

import java.util.ArrayList;

import models.Student;
import models.StudentModel;

/*
 * Objectif : Insérer, mettre à jour, supprimer, et lire des données dans une base de données.
	1. Créez une base de données nommée School avec une table Students ayant les colonnes
	suivantes : id (INT, PRIMARY KEY, AUTO_INCREMENT), name
	(VARCHAR(100)), age (INT).
	2. Écrivez un programme Java qui effectue les opérations suivantes en utilisant JDBC :
	- Insérez trois étudiants avec des noms et âges différents.
	- Mettez à jour l'âge de l'un des étudiants.
	- Supprimez un étudiant de la table.
	- Lisez et affichez tous les enregistrements de la table Students dans la console.
	- Ajoutez plusieurs enregistrements dans la table Students en utilisant les transactions
	- Ajoutez plusieurs enregistrements dans la table Students via les lots
 *
 *
*/

public class MainActivity {
	public static void main(String[] args) {
		StudentModel studentModel = new StudentModel();
		studentModel.createStudentTable();
		
//		insertion
		studentModel.insertStudent(new Student("Lka beast", 22));
		
//		Mise a jour
		studentModel.updateStudent(2, new Student("Lka the performer", 23));

//		suppression
		studentModel.deleteStudent(3);

//		Inserer plusieurs students en utilisant les transactions
		ArrayList<String> studentQueries = new ArrayList<String>();
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Atos', 233)");
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Socium', 43)");
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Sonatel', 13)");
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Tonux mentor master', 53)");
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Medoune JavaMan', 32)");
		studentQueries.add("INSERT INTO students (name, age) VALUES ('Optimus Debugger, the department', 15)");
//		this should throw an rollback and the transaction will rollback
		studentQueries.add("INSERT INTO students (name, age) VALES ('Mimistic', 40)");
		studentModel.insertStudentsTransaction(studentQueries);

//		Inserer plusieurs students en utilisant les batch
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Big company", 2025));
		students.add(new Student("My goal", 2025));
		studentModel.insertStudentsBatch(students);
		
	}
}
