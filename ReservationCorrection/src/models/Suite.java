package models;

public class Suite extends Chambre {
	private int nombreDePieces;
	
	public Suite(int numeroChambre, int nombreDePieces) {
		super(numeroChambre);
		this.nombreDePieces = nombreDePieces;
	}
	
	public void setNombreDePieces(int nombreDePieces) {
		this.nombreDePieces = nombreDePieces;
	}
	public int getNombreDePieces() {
		return this.nombreDePieces;
	}
}
