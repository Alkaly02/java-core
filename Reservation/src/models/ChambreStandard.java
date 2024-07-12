package models;

public class ChambreStandard extends Reservation {
	private int numeroChambre;
	
	public ChambreStandard(String nomClient, String dateArrivee, String dateDepart, double prix, int numeroChambre) {
		super(nomClient, dateArrivee, dateDepart, prix);
		this.numeroChambre = numeroChambre;
	}
	
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public int getNumeroChambre() {
		return this.numeroChambre;
	}
	
	public void calculerPrix() {
//		TODO: calculer le prix de la chambre en se basant sur le nombre de jour du sejour
		System.out.println("Calculer prix");
	}
	
	@Override
	public void afficherDetails() {
		super.afficherDetails();
		System.out.println("Numero chambre: " + this.getNumeroChambre());
	}
}
