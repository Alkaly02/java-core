package models;

public abstract class Chambre {
	private int numeroChambre;
	
	public Chambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public int getNumeroChambre() {
		return this.numeroChambre;
	}
}
