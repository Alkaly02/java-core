package models;

import exceptions.*;

public class Employe {
	private String nom;
	private double salaireHoraire;
	
	public Employe(String nom, double salaireHoraire) {
		this.nom = nom;
		this.salaireHoraire = salaireHoraire;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setSalaireHoraire(double salaire) {
		this.salaireHoraire = salaire;
	}
	public double getSalaireHoraire() {
		return this.salaireHoraire;
	}
	
	public double calculerSalaire(Integer nbrHeuresTravaillees) {
		if(nbrHeuresTravaillees <= 0) {
			try {
				throw new NombreHeuresInvalideException();
			}
			catch(NombreHeuresInvalideException e) {
				System.out.println(e.getMessage());
			}
			System.exit(0);
		}
		else if(this.getSalaireHoraire() <= 0) {
			try {
				throw new SalaireHoraireInvalideException("Salaire invalide");
			}
			catch(SalaireHoraireInvalideException e) {
				System.out.println(e.getMessage());
			}
			System.exit(0);
		}
		return this.getSalaireHoraire() * nbrHeuresTravaillees;
	}
}
