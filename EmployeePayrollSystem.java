package java_exercises;
import java.util.Scanner;
class Employee2{
	String name;
	double baseSalary;
	
	Employee2(String name,double baseSalary){
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	double calculateSalary() {
		return baseSalary;
	}
}

class FullTime extends Employee2{
	FullTime(String name, double baseSalary){
		super(name,baseSalary);
	}
}

class Intern extends Employee2{
	Intern(String name, double baseSalary){
		super(name,baseSalary);
	}
	
	double calculateSalary() {
		return baseSalary*0.5;
	}
}



public class EmployeePayrollSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.println("Enter employee name:");
        String name = scan.nextLine();

        System.out.println("Enter base salary:");
        double salary = scan.nextDouble();

        System.out.println("Select Employee Type:");
        System.out.println("1. Full Time");
        System.out.println("2. Intern");

        int type = scan.nextInt();

        Employee2 emp;

        // Polymorphism in action
        if (type == 1) {
            emp = new FullTime(name, salary);
        } else {
            emp = new Intern(name, salary);
        }

        System.out.println("\n----- Employee Details -----");
        System.out.println("Name: " + emp.name);
        System.out.println("Base Salary: " + emp.baseSalary);
        System.out.println("Final Salary: " + emp.calculateSalary()); // polymorphism call

        scan.close();
	}

}
