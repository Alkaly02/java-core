package operators;

import java.util.Scanner;

public class SalaryPayment {
	private final double HRA = 0.5;
	private final double SPECIAL_ALLOWANCE = 0.75;
	private final double PFD_DEDUCTION = 0.12;
	
	private long basicSalary;
	private double hra, specialAllowance, pfDeduction, netPayableSalary;
	
	private void setBasicSalary(long basicSalary) {
		this.basicSalary = basicSalary;
	}
	private long getBasicSalary() {
		return this.basicSalary;
	}
	
	private void setHra(double hra) {
		this.hra = hra;
	}
	private double getHra() {
		return this.hra;
	}
	
	private void setSpecialAllowance(double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	private double getSpecialAllowance() {
		return this.specialAllowance;
	}
	
	private void setPfDeduction(double pfDeduction) {
		this.pfDeduction = pfDeduction;
	}
	private double getPfDeduction() {
		return this.pfDeduction;
	}
	
	private void setNetPayableSalary(double salary) {
		this.netPayableSalary = salary;
	}
	private double getNetPayableSalary() {
		return this.netPayableSalary;
	}
	
	public void askBasicSalary(Scanner scn) {
		System.out.print("What is your basic salary? : ");
		long basicSalary = scn.nextLong();
		this.setBasicSalary(basicSalary);
		
//		Calcutate Net Payable Salary after getting the basic salary
		this.calculateNetPayableSalary();
	}
	
	private void calculateHraComponent() {
		this.setHra(this.HRA * this.getBasicSalary());
	}
	
	private void calculateSpecialAllowanceComponent() {
		this.setSpecialAllowance(this.SPECIAL_ALLOWANCE * this.getBasicSalary());
	}
	
	private void calculatePfDeductionComponent() {
		this.setPfDeduction(this.PFD_DEDUCTION * this.getBasicSalary());
	}
	
	private void calculateNetPayableSalary() {
		this.calculateHraComponent();
		this.calculateSpecialAllowanceComponent();
		this.calculatePfDeductionComponent();
		
//		Net payable salary = (basic+hra+special allowance) - pf deduction
		this.setNetPayableSalary((this.getBasicSalary() + this.getHra() + this.getSpecialAllowance()) - this.getPfDeduction());
	}
	
	public void displayNetPayableSalary() {
		System.out.println("The Net Payable Salary based on " + this.getBasicSalary() + " basic salary is: " + this.getNetPayableSalary());
	}
}
