package main;

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
	}
}
