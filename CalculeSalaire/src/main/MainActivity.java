package main;

import models.Employe;

public class MainActivity {
	public static void main(String args[]) {
		Employe employe1 = new Employe("Alkaly", 10000);
		double salaire = employe1.calculerSalaire(0);
		System.out.println(salaire);
	}
}
