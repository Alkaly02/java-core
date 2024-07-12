package models;

public abstract class Reservation {
	private String nomClient, dateArrivee, dateDepart;
	private double prix;
	
	public Reservation(String nomClient, String dateArrivee, String dateDepart, double prix) {
		this.nomClient = nomClient;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.prix = prix;
	}
	
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getNomClient() {
		return this.nomClient;
	}
	
	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public String getDateArrivee() {
		return this.dateArrivee;
	}
	
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getDateDepart() {
		return this.dateDepart;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPrix() {
		return this.prix;
	}
	
	public abstract void calculerPrix();
	
	public void afficherDetails() {
		System.out.println("Nom client: " + this.getNomClient() + "\n" + 
							"Date arrivee: " + this.getDateArrivee() + "\n" + 
							"Date depart: " + this.getDateDepart() + "\n" + 
							"Prix: " + this.getPrix());
	}
}
