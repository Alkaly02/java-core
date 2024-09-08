package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private Connection con;
	private Statement stmt;
	
//	1. Charger le driver
//	2. Connexion a la base de donnees
//	3. Creation des statements
//	4. Gestion des erreurs SQL
	
	public DB() {
		this.connectDB();
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	public Connection getCon() {
		return this.con;
	}
	
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public Statement getStmt() {
		return this.stmt;
	}
	
	private void loadDriver() {
		try {
			System.out.println("Driver loaded");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		}catch(ClassNotFoundException cex) {
			System.out.println("Une erreur est survenue lors du chargement du driver");
			cex.printStackTrace();
		}
	}
	
	private void connectDB() {
		loadDriver();
		try {
//			protocol:sub-protocol:sub-name
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ecole", "root", "");
			System.out.println("Connexion a la base de donnees reussie");
			this.setStmt(con.createStatement());
		}catch(SQLException sqlExc) {
			System.out.println("Une erreur est survenue lors du chargement du driver");
			sqlExc.printStackTrace();
		}
	}
	
}
