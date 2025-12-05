package java_exercises;

import java.util.Scanner;

interface Borrowable {
	void borrow();

	void returnBook();
}

class Books implements Borrowable {
	String title;
	boolean isBorrowed = false;

	Books(String title) {
		this.title = title;
	}

	public void borrow() {
		isBorrowed = true;
		System.out.println(title + " has been borrowed!");
	}

	public void returnBook() {
		isBorrowed = false;
		System.out.println(title + " has been returned");
	}
}

public class SimpleLibrarySystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter book title: ");
		String title = scan.nextLine();
		
		Books b = new Books(title);
		
		while(true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Borrow Book");
			System.out.println("2. Return Book");
			System.out.println("3. Check Status");
			System.out.println("4. Exit");
			System.out.println("Enter Choice: ");
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1: 
				if(!b.isBorrowed) {
					b.borrow();
				}else {
					System.out.println("Book is already borrowed.");
				}
				break;
			case 2:
				if(b.isBorrowed) {
					b.returnBook();
				}else {
					System.out.println("Book is already returned.");
				}
				break;
			case 3:
				System.out.println("Book: " + b.title);
				System.out.println("Status: " + (b.isBorrowed? "Borrowed": "Available"));
				break;
			case 4:
				System.out.println("Exiting...");
				System.out.println("Program ended.");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
			
		}
		
	}

}
