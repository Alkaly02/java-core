package models;

public class Suite extends Reservation {
	private int numeroChambre, nombreDePieces;
	
	public Suite(String nomClient, String dateArrivee, String dateDepart, double prix, int numeroChambre, int nombreDePieces) {
		super(nomClient, dateArrivee, dateDepart, prix);
		this.numeroChambre = numeroChambre;
		this.nombreDePieces = nombreDePieces;
	}
	
	public void setNumeroChambre(int numero) {
		this.numeroChambre = numero;
	}
	public int getNumeroChambre() {
		return this.numeroChambre;
	}
	
	public void setNombreDePieces(int nombreDePieces) {
		this.nombreDePieces = nombreDePieces;
	}
	public int getNombreDePieces() {
		return this.nombreDePieces;
	}
	
	public void calculerPrix() {
//		TODO: calculer le prix de la chambre en se basant sur le nombre de jour du sejour
		System.out.println("Calculer prix");
	}
	
	public void afficherDetails() {
		super.afficherDetails();
		System.out.println("Numero chambre: " + this.getNumeroChambre());
		System.out.println("Nombre de pieces: " + this.getNombreDePieces());
	}
}
