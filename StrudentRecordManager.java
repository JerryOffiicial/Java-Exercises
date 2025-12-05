package java_exercises;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


class Student {
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class StudentManager {
	ArrayList<Student> list = new ArrayList<>();

	void addStudent(Student s) {
		list.add(s);
	}

	Student search(int id) {
		for (Student s : list) {
			if (s.id == id) {
				return s;
			}
		}
		return null;
	}

	void saveFile() throws Exception {
		FileWriter fw = new FileWriter("students.txt");
		for (Student s : list) {
			fw.write(s.id + "." + s.name + "\n");
		}

		fw.close();
	}
}

public class StrudentRecordManager {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentManager manager = new StudentManager();

		while (true) {
			System.out.println("Welcome to the Moodle\n");
			System.out.println("01.Add Student");
			System.out.println("02.Search Student");
			System.out.println("03.List Student");
			System.out.println("04.Save to File");
			System.out.println("05.Exit");
			System.out.println("Choose Option");

			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				System.out.println("Enter Student ID: ");
				int id = scan.nextInt();
				scan.nextLine();

				System.out.println("Enter Student Name: ");
				String name = scan.nextLine();

				manager.addStudent(new Student(id, name));
				System.out.println("Student added succeddfully!");
				break;

			case 2:
				System.out.println("Enter ID to search: ");
				int sid = scan.nextInt();

				Student found = manager.search(sid);
				if (found != null) {
					System.out.println("Found: " + found.id + " - " + found.name);
				} else {
					System.out.println("Student not found!");
				}
				break;

			case 3:
				System.out.println("\n----Student List ----");
				for (Student s : manager.list) {
					System.out.println(s.id + " - " + s.name);
				}
				break;
			case 4: 
				try {
					manager.saveFile();
					System.out.println("data saved to students.txt");
				}catch(Exception e) {
					System.out.println("Error svaing file: "+ e.getMessage());
				}
				break;
			case 5:
				System.out.println("Exiting...");
				System.out.println("Program ended");
				return ;
			default:
				System.out.println("Invalid option!");
			}
		}

	}

}
