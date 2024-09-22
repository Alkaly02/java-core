package models;

public class Programme {
	private String nom;
	private int duree, nombreDeSemetre;
	
	public Programme(String nom, int duree, int nombreDeSemetre) {
		this.setNom(nom);
		this.setDuree(duree);
		this.setNombreDeSemetre(nombreDeSemetre);
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNombreDeSemetre() {
		return nombreDeSemetre;
	}

	public void setNombreDeSemetre(int nombreDeSemetre) {
		this.nombreDeSemetre = nombreDeSemetre;
	}
}
