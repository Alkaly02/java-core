package models;

import java.sql.*;

public class Student {
	private Statement stmt;
	
	private void setStmt(Statement s) {
		this.stmt = s;
	}
	private Statement getStmt() {
		return this.stmt;
	}
//	load type-4 driver
	private void loadDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException clnf) {
			clnf.printStackTrace();
		}
	}
//	connect to db
	public void connectDB() {
		this.loadDriver();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/school; user='root', password=''");
			this.setStmt(con.createStatement());
		}catch(SQLException connectionException) {
			System.out.println("Une erreur est survenue lors de la connexion a la base de donnees");
			connectionException.printStackTrace();
		}
	}
//	create a students table
	public void createStudentsTable() throws SQLException {
		String studentDDL = "CREATE TABLE students (id INT PRIMARY KEY AUTO_INCREMENTE, name varchar(100), age INT)";
		this.getStmt().execute(studentDDL);
	}
//	insert a student
	public void insertStudent(String name, int age) throws SQLException {
		String query = "INSERT INTO students (name, age) VALUES ('" + name + "', " + age + ")";
		this.getStmt().executeUpdate(query);
	}
//	update a student
	public void updateStudentAge(int id, int age) throws SQLException {
		String query = "UPDATE students SET age=" + age + "WHERE id="+id;
		this.getStmt().executeUpdate(query);
	}
//	delete a student
	public void deleteStudent(int id) throws SQLException {
		String query = "DELETE FROM students WHERE id="+id;
		this.getStmt().executeUpdate(query);
	}
}
