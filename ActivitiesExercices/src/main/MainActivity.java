package main;

import java.util.Scanner;

import operators.SalaryPayment;

public class MainActivity {
	public static void main(String args[]) {
		SalaryPayment payableSalary = new SalaryPayment();
		Scanner scn = new Scanner(System.in);
		payableSalary.askBasicSalary(scn);
		scn.close();
		payableSalary.displayNetPayableSalary();
	}
}
