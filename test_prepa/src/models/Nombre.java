package models;

public class Nombre {
	private Integer number;
	
	public Nombre(Integer number) {
//		ici on met this.number pour eviter au programme de se perdre
		this.number = number;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	public void setNumber(Integer n) {
//		ce n'est pas la peine de mettre this.number car il n'y a pas de confusion
		number = n;
	}
	
	public Integer factoriel() {
		if(this.number < 0) {
			System.out.println("Veullez fournir un nombre positif");
			return 0;
		}
		if(this.number == 0) {
			return 1;
		}
		
		Integer resultat = 1;
		for(Integer i = 1; i<= this.number; i++) {
			resultat = resultat * i;
		}
		return resultat;
	}
}
