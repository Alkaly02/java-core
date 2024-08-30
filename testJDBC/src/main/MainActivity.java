package main;

import java.sql.*;

public class MainActivity {

	public static void main(String[] args) {
		try {
//			load the driver
			Class.forName("com.mysql.jdbc.Driver");
//			connect to the database
			String url = "jdbc:mysql://localhost:3306/test_db;user=root, password=''";
			try {
				Connection con = DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from users");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
				
				con.close();
			}catch(SQLException sqlEx) {
				System.out.print("Une erreur est survenue lors de la connexion a la base de donnees");
				sqlEx.printStackTrace();
			}
		}catch(ClassNotFoundException nf) {
			
		}
	}

}
