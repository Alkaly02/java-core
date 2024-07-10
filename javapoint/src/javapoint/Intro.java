package javapoint;

import models.*;

public class Intro {
	public static void main(String args[]) {
		int a1;
		int a2;
		int add = 0;
		int prod = 0;
		a1 = 12;
		a2 = 14;
		add = a1 + a2;
		prod = a1 * a2;
		ComputeAv computeAv1 = new ComputeAv();
		System.out.println("Sum = " + add);
		System.out.println("Product = " + prod);
		computeAv1.getAvg();
	}
}
