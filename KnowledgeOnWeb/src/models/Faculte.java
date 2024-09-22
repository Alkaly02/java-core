package models;

public class Faculte {
	private String code, nom, numeroContact, email;
	
	public Faculte(String code, String nom, String numeroContact, String email) {
		this.code = code;
		this.nom = nom;
		this.numeroContact = numeroContact;
		this.email = email;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setNumeroContact(String numeroContact) {
		this.numeroContact = numeroContact;
	}
	public String getNumeroContact() {
		return this.numeroContact;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
}
