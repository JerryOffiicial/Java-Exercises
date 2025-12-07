package java_exercises;

import java.util.*;
import java.io.*;

public class QuizApplication {

	static class Question {
		String question, answer;

		Question(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}
	}

	static ArrayList<Question> load() throws Exception {
		ArrayList<Question> list = new ArrayList<>();
		Scanner scan = new Scanner(new File("questions.txt"));

		while (scan.hasNextLine()) {
			String[] parts = scan.nextLine().split(",");
			list.add(new Question(parts[0], parts[1]));
		}

		scan.close();
		return list;
	}

	// Main method
	public static void main(String[] args) {

		try {
			ArrayList<Question> quiz = load();
			Scanner scan = new Scanner(System.in);
			int score = 0;

			for (Question q : quiz) {
				System.out.println("Q: " + q.question);
				System.out.println("Your answer: ");
				String ans = scan.nextLine();

				if (ans.equalsIgnoreCase(q.answer)) {
					System.out.println("Correct!\n");
					score++;
				} else {
					System.out.println("Wrong! Correct answer: " + q.answer + "\n");
				}
			}

			System.out.println("Your Score: " + score + "/" + quiz.size());
			scan.close();
		} catch (Exception e) {
			System.out.println("Error loading question: " + e.getMessage());
		}
	}

}
