package main;

import models.*;

public class Main {
	public static void main(String[] args) {
		Livre livre1 = new Livre("Petit prince", "AST", 1943, 96, "Conte");
		Livre livre2 = new Livre("Grand prince", "ASM", 1944, 100, "Conte");
		Magazine magazine1 = new Magazine("NIIT MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
		
		livre1.afficherDetails();
		System.out.println("===========================================");
		livre2.afficherDetails();
		System.out.println("===========================================");
		magazine1.afficherDetails();
		System.out.println("===========================================");
		System.out.println("Le nombre de livre cree est: " + Livre.nombreDeLivreCrees);
	}
}
