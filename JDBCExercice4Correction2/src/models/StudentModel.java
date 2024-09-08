package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel {
//	Creation de table student
	DB db = new DB();
	
	public void createStudentTable() {
		String studentDDL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), age INT)";
		try {
			db.getStmt().execute(studentDDL);
			System.out.println("La table student a bien ete creee");
		}catch(SQLException cex) {
			System.out.println("Une erreur est survenue lors de la creation de la table student");
			cex.printStackTrace();
		}
		
	}
//	Inserer un etudiant
	public void insertStudent(Student student) {
		try {
			PreparedStatement prepStmt = db.getCon().prepareStatement("INSERT INTO students (name, age) VALUES (?, ?)");
			prepStmt.setString(1, student.getName());
			prepStmt.setInt(2, student.getAge());
			prepStmt.executeUpdate();
			System.out.println("Ajout reussi");
			prepStmt.close();
		}catch(SQLException exc) {
			exc.printStackTrace();
			exc.getMessage();
		}
	}
//	Mettre a jour un edudiant
	public void updateStudent(int id, Student student) {
		try {
			PreparedStatement prepStmt = db.getCon().prepareStatement("UPDATE students SET name=?, age=? WHERE id=?");
			prepStmt.setString(1, student.getName());
			prepStmt.setInt(2, student.getAge());
			prepStmt.setInt(3, id);
			prepStmt.executeUpdate();
			System.out.println("Mise a jour reussi");
		}catch(SQLException exc) {
			exc.getErrorCode();
			exc.getMessage();
			exc.printStackTrace();
		}
	}
//	delete a student
	public void deleteStudent(int id) {
		try {
			PreparedStatement prepStmt = db.getCon().prepareStatement("DELETE FROM students WHERE id=?");
			prepStmt.setInt(1, id);
			prepStmt.close();
		}catch(SQLException exc) {
			exc.getErrorCode();
			exc.getMessage();
			exc.getNextException();
			exc.printStackTrace();
		}
	}
//	Get all students
	public ResultSet getStudents() throws SQLException {
		String query = "SELECT * FROM students";
		ResultSet rs = db.getStmt().executeQuery(query);
		return rs;
	}
//	insert students using transactions
	public void insertStudentsTransaction(ArrayList<String> queries) {
			try {
				db.getCon().setAutoCommit(false);
				for(String query:queries) {
					db.getStmt().executeUpdate(query);
				}	
				db.getCon().commit();
			}catch(SQLException exc) {
				try {
					db.getCon().rollback();;
				}catch(SQLException rollExc) {
					rollExc.getMessage();
					rollExc.printStackTrace();
				}
				exc.getErrorCode();
				exc.getMessage();
				exc.getNextException();
				exc.printStackTrace();
			}finally {
				try {
					db.getCon().setAutoCommit(true);
				}catch(SQLException exc) {
					exc.getMessage();
					exc.printStackTrace();
				}
			}
	}
//	insert using batch
	public void insertStudentsBatch(ArrayList<Student> students) {
			try {
				PreparedStatement prepStmt = db.getCon().prepareStatement("INSERT INTO students (name, age) VALUES (?, ?)");
				for(Student student:students) {
					prepStmt.setString(1, student.getName());
					prepStmt.setInt(2, student.getAge());
					prepStmt.addBatch();
				}
				prepStmt.executeBatch();
				prepStmt.close();
			}catch(SQLException exc) {
				exc.getErrorCode();
				exc.getMessage();
				exc.printStackTrace();
			}
	}
}
