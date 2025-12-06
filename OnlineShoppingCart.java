package java_exercises;

import java.util.Scanner;
import java.util.ArrayList;

class Product {
	String name;
	double price;

	Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}

class Cart {
	ArrayList<Product> items = new ArrayList<>();

	void add(Product p) {
		items.add(p);
	}

	void remove(Product p) {
		items.remove(p);
	}

	double total() {
		double sum = 0;
		for (Product p : items) {
			sum += p.price;
		}
		return sum;
	}
}

public class OnlineShoppingCart {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Cart cart = new Cart();
		while (true) {
			System.out.println("\n--- Shopping Cart Menu ---");
			System.out.println("1. Add Product");
			System.out.println("2. Remove Product");
			System.out.println("3. View Total");
			System.out.println("4. Exit");
			System.out.println("Choose option: ");

			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter product name: ");
				String name = scan.nextLine();

				System.out.println("Enter product price: ");
				double price = scan.nextDouble();

				cart.add(new Product(name, price));
				System.out.println("Product added!");
				break;
			case 2:
				System.out.println("Enter name of product to remove: ");
				String removeName = scan.nextLine();

				// find product
				Product toRemove = null;
				for (Product item : cart.items) {
					if (item.name.equalsIgnoreCase(removeName)) {
						toRemove = item;
						break;
					}
				}

				if (toRemove != null) {
					cart.remove(toRemove);
					System.out.println("Product removed!");
				} else {
					System.out.println("Product not found in cart.");
				}
				break;
			case 3:
				for(Product p: cart.items) {
					System.out.println("Your Items\n");
					System.out.println("Item: " + p.name + " | " + "Price: "+ p.price);
				}
				System.out.println("Total Price: " + cart.total());
				break;
			case 4:
				System.out.println("Exiting...");
				scan.close();
				return;
			default:
				System.out.println("Invalid option.");
			}
		}

	}

}
