package models;

import java.sql.SQLException;

public class StudentModel {
//	Creation de table student
	DB db = new DB();
	
	public void createStudentTable() {
		String studentDDL = "CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), age INT)";
		try {
			db.getStmt().execute(studentDDL);
			System.out.println("La table student a bien ete creee");
		}catch(SQLException cex) {
			System.out.println("Une erreur est survenue lors de la creation de la table student");
			cex.printStackTrace();
		}
		
	}
	
}
