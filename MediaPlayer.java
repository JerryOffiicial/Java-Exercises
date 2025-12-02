package java_exercises;
import java.util.Scanner;

interface Playable{
	void play();
}

class Song implements Playable{
	public void play() {
		System.out.println("Song plays");
	}
}

class Video implements Playable{
public void play() {
		System.out.println("Video plays");
	}
}

class Podcast implements Playable{
public void play() {
		System.out.println("Podcast plays");
	}
}

public class MediaPlayer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose the option to play next! Song or Video or Podcast");
		String option = scan.nextLine();
		
		if(option.equals("Song")) {
			Song s1 = new Song();
			s1.play();
		}else if(option.equals("Video")) {
			Video v1 = new Video();
			v1.play();
		}else if(option.equals("Podcast")) {
			Podcast p1 = new Podcast();
			p1.play();
		}else {
			System.out.println("Wrong Choice");
		}
		
		System.out.println();
		
		System.out.println("Program is ended! :)");
	}

}
