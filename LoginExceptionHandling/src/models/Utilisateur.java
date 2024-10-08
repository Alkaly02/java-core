package models;

import exceptions.*;

public class Utilisateur {
	private String nomUtilisateur, motDePasse;
	
	public Utilisateur(String nomUtilisateur, String motDePasse) {
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
	}
	
	public void setNomUtilisateur(String nom) {
		this.nomUtilisateur = nom;
	}
	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getMotDePasse() {
		return this.motDePasse;
	}
	
	public void seConnecter(String nomUtilisateur, String motDePasse) throws NomUtilisateurInvalideException, MotDePasseInvalideException {
		if(this.getNomUtilisateur() != nomUtilisateur) {
			throw new NomUtilisateurInvalideException();
		}
		else if(this.getMotDePasse() != motDePasse) {
			throw new MotDePasseInvalideException("Mot de passe incorrecte");
		}
		else {
			System.out.println("Utilisateur connecte avec succes");
		}
	}
}
