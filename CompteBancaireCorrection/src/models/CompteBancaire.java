package models;

public class CompteBancaire {
	private double solde;
	private String titulaire;
	
	public CompteBancaire(double solde, String titulaire) {
		this.solde = solde;
		this.titulaire = titulaire;
	}
	
	public void deposer(double montant) {
		this.solde = this.solde + montant;
	}
	
	public void retirer(double montant) {
		if((this.solde - montant) < 0) {
			System.out.println(this.titulaire + " sa xaliss doyoul");
		}
		this.solde = this.solde - montant;
	}
	
	public double consulterSolde() {
		return this.solde;
	}
}
