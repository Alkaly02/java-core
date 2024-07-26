package main;

import exceptions.NombreHeuresInvalideException;
import exceptions.SalaireHoraireInvalideException;
import models.Employe;

public class MainActivity {
	public static void main(String args[]) {
		Employe employe1 = new Employe("Alkaly", 10000);
		double salaire;
		try {
			salaire = employe1.calculerSalaire(0);
			System.out.println(salaire);
		}catch(NombreHeuresInvalideException e) {
			System.out.println(e.getMessage());
		}
		catch(SalaireHoraireInvalideException e) {
			System.out.println(e.getMessage());
		}
	}
}
