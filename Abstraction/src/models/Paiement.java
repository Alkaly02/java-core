package models;

public abstract class Paiement {
	private double montant;
	
	public Paiement(double montant) {
		this.montant = montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double getMontant() {
		return this.montant;
	}
	
	public abstract void effectuerPaiement();;
	
	public void afficherDetails() {
		System.out.println("Motant: "+ this.getMontant());
	}
}