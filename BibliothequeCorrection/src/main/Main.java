package main;

import java.util.ArrayList;

import models.*;

public class Main {
	public static void main(String[] args) {
		Livre livre1 = new Livre("Petit prince", "AST", 1943, 96, "Conte");
		Livre livre2 = new Livre("Grand prince", "ASM", 1944, 100, "Conte");
		
		Magazine magazine1 = new Magazine("NIIT MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
		Magazine magazine2 = new Magazine("LKA MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
		
		ArrayList<Livre> livres = new ArrayList<Livre>();
		livres.add(livre1);
		livres.add(livre2);
		
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		magazines.add(magazine1);
		magazines.add(magazine2);
		
		for(Livre livre:livres) {
			livre.afficherDetails();
		}
		
		for(Magazine magazine:magazines) {
			magazine.afficherDetails();
		}
		
		System.out.println("Le nombre de livre cree est: " + Livre.nombreDeLivreCrees);
	}
}
