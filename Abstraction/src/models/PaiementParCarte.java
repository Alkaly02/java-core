package models;

import java.util.Date;

public class PaiementParCarte extends Paiement {
	private String numeroCarte;
	private Date dateExpiration;
	
	public PaiementParCarte(double montant, String numeroCarte, Date dateExpiration) {
		super(montant);
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
	}
	
	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public String getNumeroCarte() {
		return this.numeroCarte;
	}
	
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	public Date getDateExpiration() {
		return this.dateExpiration;
	}
	
	@Override
	public void effectuerPaiement() {
		System.out.println("Paiement effectue par carte");
	}
	
	@Override
	public void afficherDetails() {
		super.afficherDetails();
		System.out.println("Numero carte: "+ this.getNumeroCarte() + "\n" + 
							"Date d'expiration: " + this.getDateExpiration());
	}
}
