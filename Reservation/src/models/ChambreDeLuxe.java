package models;

public class ChambreDeLuxe extends Reservation {
	private int numeroChambre;
	private boolean vueSurMer;
	
	public ChambreDeLuxe(String nomClient, String dateArrivee, String dateDepart, double prix, int numeroChambre, boolean vueSurMer) {
		super(nomClient, dateArrivee, dateDepart, prix);
		this.numeroChambre = numeroChambre;
		this.vueSurMer = vueSurMer;
	}
	
	public void setNumeroChambre(int numero) {
		this.numeroChambre = numero;
	}
	public int getNumeroChambre() {
		return this.numeroChambre;
	}
	
	public void setVueSurMer(boolean vueSurMer) {
		this.vueSurMer = vueSurMer;
	}
	public boolean getVueSurMer() {
		return this.vueSurMer;
	}
	
	public void calculerPrix() {
//		TODO: calculer le prix de la chambre en se basant sur le nombre de jour du sejour
		System.out.println("Calculer prix");
	}
	
	public void afficherDetails() {
		super.afficherDetails();
		System.out.println("Numero chambre: " + this.getNumeroChambre());
		String vueSurMer = this.getVueSurMer() ? "Oui" : "Non";
		System.out.println("Vue sur mer: " + vueSurMer);
	}
}
