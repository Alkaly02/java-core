package models;

public class Magazine extends BibliothequeElement {
	private String editeur, frequencePublication;
	
	public Magazine(String titre, String auteur, int anneePublication, String editeur, String frequencePublication) {
		super(titre, auteur, anneePublication);
		this.editeur = editeur;
		this.frequencePublication = frequencePublication;
	}
	
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public String getEditeur() {
		return this.editeur;
	}
	
	public void setFrequencePublication(String freq) {
		this.frequencePublication = freq;
	}
	public String getFrequencePublication() {
		return this.frequencePublication;
	}
	
	@Override
	public void afficherDetails() {
		super.afficherDetails();
		System.out.println("Editeur: " + this.getEditeur() + "\n" + 
						   "Frequence de publication: " + this.getFrequencePublication());
	}
}
