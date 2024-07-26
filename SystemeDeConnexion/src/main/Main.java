package main;

import exceptions.*;
import models.Utilisateur;

public class Main {
	public static void main(String[] args) {
		Utilisateur alkaly = new Utilisateur("Alkaly", "alkaly01");
		
		try {
			alkaly.seConnecter("Alkaly", "alkaly01");
		}catch(MotDePasseInvalideException e) {
			System.out.println(e.getMessage());
		}
		catch(NomUtilisateurInvalideException e) {
			System.out.println(e.getMessage());
		}
	}
}
