package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student{
	public static Connection con;
	
//	Chargement du driver
	private static void loadDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Une erreur est survenue lors du chargement du driver");
			ex.printStackTrace();
		}
	}
	
//	connexion a la base de donnees
	public static void connectDb() {
		loadDriver();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole", "root", "");
			System.out.println("*******Connected to db***********");
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la connexion a la base de donnees");
			ex.printStackTrace();
		}
	}
//	Creation de la table students
	public static void createStudentTable() {
		String studentDDL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), age INT)";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(studentDDL);
			System.out.println("La table students a ete creer avec succes");
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la connexion a la creation de la table students");
			ex.printStackTrace();
		}
	}
//	creation d'un user
	public static void createUser(String nom, int age) {
		createStudentTable();
		String query = "INSERT INTO students (name, age) VALUES (?, ?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, nom);
			preparedStatement.setInt(2, age);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println(nom + " a ete ajoute avec succes");
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la creation de " + nom);
			ex.printStackTrace();
		}
	}
//	recuperer les eleves
	public static ResultSet getStudents() throws SQLException {
		String query = "SELECT * FROM students";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}
//	Rechercher un user
	public static ResultSet searchStudent(String name) throws SQLException {
		String query = "SELECT * FROM students WHERE name LIKE ?";
		PreparedStatement prepStmt = con.prepareStatement(query);
		prepStmt.setString(1, "%" + name +"%");
		ResultSet rs = prepStmt.executeQuery();
		return rs;
	}
//	Mettre a jour l'age d'un etudiant
	public static void updateStudent(String name, int age) {
		String query = "UPDATE students SET age=? WHERE name=?";
		try {
			PreparedStatement prepStmt = con.prepareStatement(query);
			prepStmt.setInt(1, age);
			prepStmt.setString(2, name);
			prepStmt.execute();
			prepStmt.close();
		}catch(SQLException ex) {
			System.out.println("Une erreur est survenue lors de la mise a jour");
			ex.printStackTrace();
		}
	}
	
	
}