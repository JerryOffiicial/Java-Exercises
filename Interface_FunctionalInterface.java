package java_exercises;

import java.util.ArrayList;
import java.util.Scanner;

interface Operation {
	int execute(int a, int b);
}

class AddOperation implements Operation {
	@Override
	public int execute(int a, int b) {
		return a + b;
	}
}

class SubstractOperation implements Operation {
	@Override
	public int execute(int a, int b) {
		return a - b;
	}
}

class MultiplyOperation implements Operation {
	@Override
	public int execute(int a, int b) {
		return a * b;
	}
}

class DivideOperation implements Operation {
	@Override
	public int execute(int a, int b) {
		if (b == 0) {
			System.out.println("Error: Cannot divide by zero.");
			return 0;
		}
		return a / b;
	}
}

class Calculator {
	ArrayList<Operation> operations = new ArrayList<>();

	void addOperation(Operation op) {
		operations.add(op);
	}

	void listOperations() {
		System.out.println("Available operations: " + operations.size());
	}

	int run(Operation op, int a, int b) {
		return op.execute(a, b);
	}

}

@FunctionalInterface
interface FunctionalOperation {
	int apply(int a, int b);
}

public class Interface_FunctionalInterface {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		Operation add = new AddOperation();
		Operation sub = new SubstractOperation();
		Operation mul = new MultiplyOperation();
		Operation div = new DivideOperation();

		calc.addOperation(add);
		calc.addOperation(sub);
		calc.addOperation(mul);
		calc.addOperation(div);

		calc.listOperations();

		System.out.println("Add: " + calc.run(add, 10, 5));
		System.out.println("Substract: " + calc.run(sub, 10, 5));
		System.out.println("Multiply: " + calc.run(mul, 10, 5));
		System.out.println("Divide: " + calc.run(div, 10, 5));

		// Functional Interface (Lambda)
		FunctionalOperation mod = (a, b) -> a % b;
		System.out.println("Modulus using lamda: " + mod.apply(10, 3));
	}

}
