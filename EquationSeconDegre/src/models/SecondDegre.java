package models;

import exceptions.CoefficientInvalideException;
import exceptions.DiscriminantNegatifException;

public class SecondDegre {
	private int a, b, c;
	private Double delta;
	
	public SecondDegre(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void setA(int a) {
		this.a = a;
	}
	public int getA() {
		return this.a;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	public int getB() {
		return this.b;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	public int getC() {
		return this.c;
	}
	
	public void setDiscriminant(Double discriminant) {
		this.delta = discriminant;
	}
	public Double getDiscriminant() {
		return this.delta;
	}
	
	public void calculerDiscriminant() throws CoefficientInvalideException, DiscriminantNegatifException {
		if(this.getA() == 0 || this.getB() == 0) {
			throw new CoefficientInvalideException();
		}
		
		Double delta = Math.pow(this.getB(), 2) - 4 * (this.getA() * this.getC());
		
		if(delta < 0) {
			throw new DiscriminantNegatifException("Cette équation n’admet pas de solutions réelles");
		}
		
		this.setDiscriminant(delta);
	}
	
	public void resoudre() throws CoefficientInvalideException, DiscriminantNegatifException {
		this.calculerDiscriminant();
			
		if(this.getDiscriminant() == 0) {
			int x0 = -this.getB() / (2*this.getA());
			System.out.println("Cette equation a une solution unique qui est :" + x0);
		}
		if(this.getDiscriminant() > 0) {
			Double x1 = (-this.getB() - Math.sqrt(this.getDiscriminant())) / 2*this.getA();
			Double x2 = (-this.getB() + Math.sqrt(this.getDiscriminant())) / 2*this.getA();
			
			System.out.println("Cette equation admet une solution:");
			System.out.println("x1: " + x1);
			System.out.println("x2: " + x2);
		}
	}
}
