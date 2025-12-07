package java_exercises;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

class ChatLogger {
	FileWriter fw;

	ChatLogger() throws Exception {
		fw = new FileWriter("chat.txt", true);// true → append mode (does not delete previous chats)
	}

	void log(String msg) throws Exception {
		fw.write(new Date() + ": " + msg + "\n");
		fw.flush();// ensures data is written immediately
	}
	
	void getMessage() throws Exception {
		FileReader fr = new FileReader("chat.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line= br.readLine();
		
		while(line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
}

public class ChatHistoryLogger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		

		try {
			ChatLogger logger = new ChatLogger();

			while (true) {
				System.out.println("\n--- CHAT LOGGER ---");
				System.out.println("1. Write Message");
				System.out.println("2. Exit");
				System.out.println("3. View The Messages");
				System.out.println("Choose: ");

				int option = scan.nextInt();
				scan.nextLine();

				switch (option) {
				case 1:
					System.out.println("Enter your message: ");
					String message = scan.nextLine();

					logger.log(message);
					System.out.println("Message Saved!");
					break;
				case 2:
					System.out.println("Exiting...");
					scan.close();
					return;
				case 3:
					System.out.println("--Your Messages--");
					logger.getMessage();
					break;
				default:
					System.out.println("Invalid option!");
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
