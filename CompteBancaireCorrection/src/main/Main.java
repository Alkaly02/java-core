package main;

import models.*;

public class Main {
	public static void main(String args[]) {
		CompteBancaire niitCompteBancaire = new CompteBancaire(1000, "NIIT");
		
		niitCompteBancaire.retirer(500);
		niitCompteBancaire.deposer(10);
		
		System.out.println("Votre solde est de:" + niitCompteBancaire.consulterSolde());
	}
}
