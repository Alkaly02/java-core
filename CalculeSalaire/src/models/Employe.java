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
	
	public double calculerSalaire(Integer nbrHeuresTravaillees) throws NombreHeuresInvalideException, SalaireHoraireInvalideException {
		if(nbrHeuresTravaillees <= 0) {
			throw new NombreHeuresInvalideException();
		}
		else if(this.getSalaireHoraire() <= 0) {
			throw new SalaireHoraireInvalideException("Salaire invalide");
		}
		return this.getSalaireHoraire() * nbrHeuresTravaillees;
	}
}
