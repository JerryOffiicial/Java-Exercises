package java_exercises;

import java.io.*;

class MiniFileManager {
	void createFile(String path) {
		File file = new File(path);
		try {
			if (file.createNewFile()) {
				System.out.println("File Created: " + file.getName());
			} else {
				System.out.println("File already exist.");
			}
		} catch (IOException e) {
			System.out.println("Error creating file: " + e.getMessage());
		}
	}

	void writeText(String path, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(text);
			System.out.println("Text written to file");
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	void appendText(String path, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
			writer.newLine();
			writer.write(text);
			System.out.println("Text appended to file");
			writer.close();
		} catch (IOException e) {
			System.out.println("Error appending to file: " + e.getMessage());
		}
	}

	void readText(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			System.out.println("----File Content----");
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("_____________________");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

}

public class FileManagerUtility {

	public static void main(String[] args) {
		MiniFileManager fm = new MiniFileManager();

		String path = "text.txt";

		fm.createFile(path);
		fm.writeText(path, "Hello from Jerry!");
		fm.appendText(path, "This is appended line.");
		fm.readText(path);
	}

}
