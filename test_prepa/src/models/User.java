package models;

public class User {
	private String prenom;
	private String nom;
	
	public User(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
