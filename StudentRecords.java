package java_exercises;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

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

class FileWrite{
	void FileWrite() {
		try {
			FileWriter fw = new FileWriter("students.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Name: " + "Jerry");
			bw.newLine();
			bw.write("Age: " + 18);
			bw.newLine();
			bw.write("Address: " + "Kandy");
			bw.newLine();
			bw.close();

		} catch (Exception e) {
			System.out.println("Something has happened: " + e);
		}
	}
}

public class StudentRecords {

	public static void main(String[] args) {
		FileWrite fw1 = new FileWrite();
		FileRead fr1 = new FileRead();

		
		
		System.out.println();
		System.out.println("The Recent Activity");
		fw1.FileWrite();
		fr1.FileRead();
		System.out.println();
		System.out.println("Program ended");

	}

}
