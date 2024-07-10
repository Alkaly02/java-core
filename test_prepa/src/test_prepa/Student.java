package test_prepa;

public class Student {
	private String prenom;
	private String nom;
	
	public Student(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public String getEtudiantPrenom() {
		return this.prenom;
	}
	public String getEtudiantNom() {
		return this.nom;
	}
}
