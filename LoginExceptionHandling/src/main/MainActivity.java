package main;

import models.Utilisateur;

public class MainActivity {
	public static void main(String[] args) {
		Utilisateur user1 = new Utilisateur("alkaly02", "passer123");
		
		user1.seConnecter("alkaly02", "passer12");
	}
}
