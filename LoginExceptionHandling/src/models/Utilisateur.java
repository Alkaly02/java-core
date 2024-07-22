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
	
	public void seConnecter(String nomUtilisateur, String motDePasse) {
		if(this.getNomUtilisateur() != nomUtilisateur) {
			try {
				throw new NomUtilisateurInvalideException();
			}
			catch(NomUtilisateurInvalideException e) {
				System.out.println(e.getMessage());;
			}
		}
		else if(this.getMotDePasse() != motDePasse) {
			try {
				throw new MotDePasseInvalideException("Mot de passe incorrecte");
			}
			catch(MotDePasseInvalideException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("Utilisateur connecte avec succes");
		}
	}
}
