package main;

import java.sql.*;

/*

For this code to work, you need to have the MySql connector driver, you can find it here: https://drive.google.com/file/d/1IME-QlI57XuzMhsqzhouH5iYyPApGMwR/view

You're welcome !!!!

*/

class Student{
	private Statement stmt;
	
	private void setStmt(Statement statement) {
		this.stmt = statement;
	}
	private Statement getStmt() {
		return this.stmt;
	}
	
	public void connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/school", "root", "");
				this.setStmt(con.createStatement());
				System.out.println("Connexion a la base de donnees reussie");
			}catch(SQLException sqle) {
				System.out.println("Une erreur est survenue lors de la connexion a la base de donnees");
				sqle.printStackTrace();
			}
		}catch(ClassNotFoundException cnf) {
			System.out.println("Une erreur est survenue lors du chargement du driver");
			cnf.printStackTrace();
		}
	}
//	create students table
	public void createStudentTable() throws SQLException {
		String studentTableDDL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), age INT)";
		this.getStmt().execute(studentTableDDL);
		System.out.println("Creation de la table students reussie");
	}
//	create a new student
	public void createStudent(String name, int age) throws SQLException {
		String query = "INSERT INTO students (name, age) VALUES ('" + name + "', " +  age + ")";
		this.getStmt().executeUpdate(query);
		System.out.println("Insertion reussie");
	}
//	update a new student
	public void updateStudent(int id, int age) throws SQLException {
		String queryUpdate = "UPDATE students SET age=" + age + " WHERE id="+id;
		this.getStmt().executeUpdate(queryUpdate);
		System.out.println("Mise a jour reussie");
	}
//	delete a student
	public void deleteStudent(int id) throws SQLException {
		String queryUpdate = "DELETE FROM students WHERE id="+id;
		this.getStmt().executeUpdate(queryUpdate);
		System.out.println("L'utilisateur avec l'id " + id + " a ete supprime");
	}
//	get all students and display them to the console
	public void getStudents() throws SQLException {
		String query = "SELECT * FROM students";
		ResultSet rs = this.getStmt().executeQuery(query);
		while(rs.next()) {
			System.out.println("Name: " + rs.getString("name")+ "-" +
								"Age: " + rs.getInt("age"));
			System.out.println("\n");
		}
	}
}






public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.connectDb();
		try {
//			student.createStudentTable();
//			student.createStudent("Alkaly", 65);
//			student.createStudent("Moussa", 65);
//			student.createStudent("Keba", 65);
//			student.updateStudent(3, 80);
//			student.deleteStudent(3);
			student.getStudents();
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
