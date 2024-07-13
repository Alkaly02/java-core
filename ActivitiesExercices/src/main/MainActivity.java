package main;

import operators.SalaryPayment;

public class MainActivity {
	public static void main(String args[]) {
		SalaryPayment payableSalary = new SalaryPayment();
		
		payableSalary.askBasicSalary();
		payableSalary.displayNetPayableSalary();
	}
}
