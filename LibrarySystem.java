package java_exercises;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
	String title;
	String author;
	int id;

	Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;

	}

	public String toString() {
		return "ID:" + id + " | Title: " + title + " | Author: " + author;
	}

}

class Library {
	ArrayList<Book> books = new ArrayList<>();

	// add a book

	void addBook(Book book) {
		books.add(book);
		System.out.println("Book added successfully!");
	}

	// remove a book by ID
	void removeBook(int id) {
		for (Book b : books) {
			if (b.id == id) {
				books.remove(b);
				System.out.println("Book removed successfully!");
				return;
			}
		}

		System.out.println("Book not found!");

	}

	// search book by title
	Book searchBook(String title) {
		for (Book b : books) {
			if (b.title.equalsIgnoreCase(title)) {// it will ignores the upper case
				return b;
			}
		}
		return null;
	}

	// List all books
	void listBooks() {
		if (books.isEmpty()) {
			System.out.println("No books in the library");
			return;
		}

		System.out.println("------Book List------");
		for (Book b : books) {
			System.out.println(b);
		}
	}
}

public class LibrarySystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Library library = new Library();

		while (true) {
			System.out.println("\n---LIBRARY MENU---");
			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Search Book");
			System.out.println("4. List All Books");
			System.out.println("5. Exit");
			System.out.println("Choose an option: ");

			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 1) {
				System.out.println("Enter Book ID: ");
				int id = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Book Title: ");
				String title = scan.nextLine();

				System.out.println("Enter Author Name: ");
				String author = scan.nextLine();

				library.addBook(new Book(id, title, author));

			} else if (choice == 2) {
				System.out.println("Enter Book ID to remove: ");
				int id = scan.nextInt();
				library.removeBook(id);

			} else if (choice == 3) {
				System.out.println("Enter Book Title to search: ");
				String title = scan.nextLine();

				Book result = library.searchBook(title);

				if (result != null) {
					System.out.println("Book Found: " + result);
				} else {
					System.out.println("Book not found!");
				}

			} else if (choice == 4) {
				library.listBooks();

			} else if (choice == 5) {
				System.out.println("Exiting program. Thank you!");
				break;

			} else {
				System.out.println("Invalid option!");
			}
		}
	}

}
