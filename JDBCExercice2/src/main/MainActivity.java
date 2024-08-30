package main;

import java.sql.*;

public class MainActivity {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
				Statement stmt = con.createStatement();
//				DDL
				String usersTableDDL = "CREATE TABLE students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT)";
//				INSERT
				String createUser1 = "INSERT INTO students (name, age) VALUES ('Alkaly', 100)";
				String createUser2 = "INSERT INTO students (name, age) VALUES ('Moussa', 100)";
				String createUser3 = "INSERT INTO students (name, age) VALUES ('KEBA', 100)";
				stmt.execute(usersTableDDL);
				stmt.execute(createUser1);
				stmt.execute(createUser2);
				stmt.execute(createUser3);
//				UPDATE
				String updateUserWithId1 = "UPDATE students SET age=88 WHERE id=1";
				stmt.executeUpdate(updateUserWithId1);
//				DELETE
				String deleteUser = "DELETE FROM students WHERE id=2";
				stmt.execute(deleteUser);
//				GET ALL students
				String query = "SELECT * FROM students";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					System.out.println(rs.getInt(0));
				}
				con.close();
			}catch(SQLException sqlie) {
				System.out.println("Une erreur est survenue lors de la connexion a la base de donnees");
				sqlie.printStackTrace();
			}
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}

}
