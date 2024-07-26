package main;

import exceptions.MotDePasseInvalideException;
import exceptions.NomUtilisateurInvalideException;
import models.Utilisateur;

public class MainActivity {
	public static void main(String[] args) {
		Utilisateur user1 = new Utilisateur("alkaly02", "passer123");
		
		try {
			user1.seConnecter("alkaly02", "passer12");
		}catch(NomUtilisateurInvalideException e) {
			System.out.println(e.getMessage());
		}catch(MotDePasseInvalideException e) {
			System.out.println(e.getMessage());
		}
	}
}
