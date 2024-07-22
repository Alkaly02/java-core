package main;

import java.util.ArrayList;

import models.*;

public class Main {
	public static void main(String[] args) {
		Livre livre1 = new Livre("Petit prince", "AST", 1943, 96, "Conte");
		Livre livre2 = new Livre("Grand prince", "ASM", 1944, 100, "Conte");
		
		Magazine magazine1 = new Magazine("NIIT MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
		Magazine magazine2 = new Magazine("LKA MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
		
		ArrayList<BibliothequeElement> bibliotheques = new ArrayList<BibliothequeElement>();
		
		bibliotheques.add(livre1);
		bibliotheques.add(livre2);
		bibliotheques.add(magazine1);
		bibliotheques.add(magazine2);
		
		for(BibliothequeElement item : bibliotheques) {
			item.afficherDetails();
		}
		
		System.out.println("Le nombre de livre cree est: " + Livre.nombreDeLivreCrees);
	}
}
