package java_exercises;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

class FileRead {
	void FileRead() {
		try {
			FileReader fr = new FileReader("students.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Something happened: " + e);
		}
	}
}

class FileWrite {
	void FileWrite(String name, int age, String address) {
		try {
			FileWriter fw = new FileWriter("students.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Name: " + name);
			bw.newLine();
			bw.write("Age: " + age);
			bw.newLine();
			bw.write("Address: " + address);
			bw.newLine();
			bw.close();

		} catch (Exception e) {
			System.out.println("Something has happened: " + e);
		}
	}
}

public class StudentRecords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the name:");
		String name = scan.nextLine();

		System.out.println("Enter the age:");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the address:");
		String address = scan.nextLine();

		FileWrite fw1 = new FileWrite();
		FileRead fr1 = new FileRead();

		System.out.println();
		System.out.println("The Recent Entry");
		fw1.FileWrite(name, age, address);
		fr1.FileRead();
		System.out.println();
		System.out.println("Program ended");

	}

}
