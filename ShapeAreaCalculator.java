package java_exercises;

import java.util.ArrayList;

abstract class Shape {
	abstract double calculateArea();
}

class Circle extends Shape {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double calculateArea() {
		return Math.PI * radius * radius;
	}
}

class Rectangle extends Shape {
	double width;
	double height;

	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	double calculateArea() {
		return width * height;
	}
}

class Triangle extends Shape {

	double base;
	double height;

	Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	double calculateArea() {
		return 0.5 * base * height;
	}
}

public class ShapeAreaCalculator {

	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<>();

		shapes.add(new Circle(5));
		shapes.add(new Rectangle(4, 7));
		shapes.add(new Triangle(3, 7));
		for (Shape s : shapes) {
			System.out.println("Area: " + s.calculateArea());
		}
	}

}
