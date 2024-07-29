package main;

import exceptions.CoefficientInvalideException;
import exceptions.DiscriminantNegatifException;
import models.SecondDegre;

public class MainActivity {
	public static void main(String[] args) {
		SecondDegre equation = new SecondDegre(4,0, 5);
		try {
			equation.resoudre();
		}
		catch(CoefficientInvalideException e) {
			System.out.println(e.getMessage());
		}
		catch(DiscriminantNegatifException e) {
			System.out.println(e.getMessage());
		}
	}
}
