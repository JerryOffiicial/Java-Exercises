package java_exercises;

import java.util.Scanner;

class Employee {
	String name;
	int id;

	Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	double calculateSalary() {
		return 0;
	}
}

class FullTimeEmployee extends Employee {
	double baseSalary;
	double allowance;

	FullTimeEmployee(String name, int id, double baseSalary, double allowance) {
		super(name, id);
		this.baseSalary = baseSalary;
		this.allowance = allowance;
	}

	double calculateSalary() {
		return baseSalary + allowance;
	}

}

class PartTimeEmployee extends Employee {
	double hourlyRate;
	int hoursWorked;

	PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
		super(name, id);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}

public class EmployeeSalaryCal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Which option do you want? FTE or PTE");
		String option = scan.nextLine();

		if (option.equals("FTE")) {

			System.out.println("Enter the Employee's Name: ");
			String name = scan.nextLine();
			System.out.println("Enter the Employee's ID: ");
			int id = scan.nextInt();
			System.out.println("Enter the E's Base Salary: ");
			double baseSalary = scan.nextDouble();
			System.out.println("Enter the E's Allowance: ");
			double allowance = scan.nextDouble();

			FullTimeEmployee fte1 = new FullTimeEmployee(name, id, baseSalary, allowance);
			System.out.println(fte1.name + "'s Full Time Employee Salary: " + fte1.calculateSalary());

		} else if (option.equals("PTE")) {

			System.out.println("Enter the Employee's Name: ");
			String name = scan.nextLine();
			System.out.println("Enter the Employee's ID: ");
			int id = scan.nextInt();
			System.out.println("Enter the E's Hourly Rate: ");
			double hourlyRate = scan.nextDouble();
			System.out.println("Enter the E's Hourly Worked: ");
			int hourlyWorked = scan.nextInt();

			PartTimeEmployee pte1 = new PartTimeEmployee(name, id, hourlyRate, hourlyWorked);
			System.out.println(pte1.name + "'s Part Time Employee Salary: " + pte1.calculateSalary());
		} else {
			System.out.println("Wrong Selection! :(");
		}

		System.out.println("Program is ended! Thank you :)");

	}

}
