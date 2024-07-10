package models;

import java.util.*;

public class ComputeAv 
{
	double a1;
	double b1;
	double sum1 = 0;
	double avg1 = 0;

	public void getAvg() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Input the first number: ");
		a1 = scnr.nextDouble();
		System.out.println("Input the second number: ");
		b1 = scnr.nextDouble();
		
		sum1 = a1 + b1;
		avg1 = sum1/2;
		
		System.out.println("Avarage = "+avg1);
	}
}
