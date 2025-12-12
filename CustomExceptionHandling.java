package java_exercises;
import java.util.InputMismatchException;
import java.util.Scanner;

class ErrorExceptionHandling extends Exception {
	public ErrorExceptionHandling(String message) {
		super(message);
	}
}

class UserInputHandle {
	int readNumber() throws ErrorExceptionHandling {
		Scanner scan = new Scanner(System.in);

		try {
			System.out.print("Enter a number: ");
			int num = scan.nextInt();

			if (num > 10000) {
				throw new ErrorExceptionHandling("Number cannot be greater than 10000");
			}
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter only digits.");
			return -1;
		} finally {
			System.out.println("Input attempt completed.");
		}
	}

	int safeDivide(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			System.out.println("Error: Cannot divide by zero");
			return 0;
		}
	}

}

public class CustomExceptionHandling {
	public static void main(String[] args) {
		UserInputHandle input = new UserInputHandle();
		
		try {
			int num1 = input.readNumber();
			int num2 = input.readNumber();
			
			int result = input.safeDivide(num1, num2);
			System.out.println("Result: "+ result);
		}catch(ErrorExceptionHandling e) {
			System.out.println("Custom Exception: " + e.getMessage());
		}
	}
}
