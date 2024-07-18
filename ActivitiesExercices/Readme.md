# SalaryPayment Java Program

This Java program calculates the net payable salary of an employee based on their basic salary. It takes into account House Rent Allowance (HRA), Special Allowance, and Provident Fund Deduction (PFD).

## Features

- Prompts the user to enter their basic salary.
- Calculates HRA, Special Allowance, and PFD based on predefined percentages.
- Computes the net payable salary by summing up the basic salary, HRA, and Special Allowance, then subtracting the PFD.
- Displays the net payable salary to the user.

## Class Structure

### Constants
- `HRA`: House Rent Allowance, fixed at 50% of the basic salary.
- `SPECIAL_ALLOWANCE`: Special Allowance, fixed at 75% of the basic salary.
- `PFD_DEDUCTION`: Provident Fund Deduction, fixed at 12% of the basic salary.

### Variables
- `basicSalary`: The basic salary of the employee.
- `hra`: The calculated House Rent Allowance.
- `specialAllowance`: The calculated Special Allowance.
- `pfDeduction`: The calculated Provident Fund Deduction.
- `netPayableSalary`: The final net payable salary after all calculations.

## Methods

- `setBasicSalary(long basicSalary)`: Sets the basic salary.
- `getBasicSalary()`: Returns the basic salary.
- `setHra(double hra)`: Sets the HRA.
- `getHra()`: Returns the HRA.
- `setSpecialAllowance(double specialAllowance)`: Sets the Special Allowance.
- `getSpecialAllowance()`: Returns the Special Allowance.
- `setPfDeduction(double pfDeduction)`: Sets the PFD.
- `getPfDeduction()`: Returns the PFD.
- `setNetPayableSalary(double salary)`: Sets the net payable salary.
- `getNetPayableSalary()`: Returns the net payable salary.
- `askBasicSalary(Scanner scn)`: Prompts the user to input their basic salary and calculates the net payable salary.
- `calculateHraComponent()`: Calculates the HRA based on the basic salary.
- `calculateSpecialAllowanceComponent()`: Calculates the Special Allowance based on the basic salary.
- `calculatePfDeductionComponent()`: Calculates the PFD based on the basic salary.
- `calculateNetPayableSalary()`: Calculates the net payable salary.
- `displayNetPayableSalary()`: Displays the net payable salary.

## Usage

To use this program, you need to compile and run the `SalaryPayment` class. It will prompt you to enter your basic salary and then display the net payable salary.

### Example

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SalaryPayment salaryPayment = new SalaryPayment();

        salaryPayment.askBasicSalary(scn);
        salaryPayment.displayNetPayableSalary();
        
        scn.close();
    }
}
```

This example demonstrates how to create an instance of the `SalaryPayment` class, prompt the user to enter their basic salary, and display the net payable salary.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.

## Contact

For any questions or inquiries, please contact [Me](mailto:lka.dev02@gmail.com).

