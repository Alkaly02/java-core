package models;

public class ChambreDeLuxe extends Chambre {
	private boolean vueSurMer;
	
	public ChambreDeLuxe(int numeroChambre, boolean vueSurMer) {
		super(numeroChambre);
		this.vueSurMer = vueSurMer;
	}
	
	public void setVueSurMer(boolean vueSurMer) {
		this.vueSurMer = vueSurMer;
	}
	public boolean getVueSurMer() {
		return this.vueSurMer;
	}
}
