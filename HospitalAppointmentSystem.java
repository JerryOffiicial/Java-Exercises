package java_exercises;

import java.util.Scanner;
import java.util.ArrayList;

class Appointment {
	String doctor, patient, date;

	Appointment(String doctor, String patient, String date) {
		this.doctor = doctor;
		this.patient = patient;
		this.date = date;
	}
}

class AppointmentManager {
	ArrayList<Appointment> list = new ArrayList<>();

	void book(Appointment a) throws Exception {
		for (Appointment x : list) {
			if (x.doctor.equals(a.doctor) && x.date.equals(a.date)) {
				throw new Exception("Slot already booked!");
			}
		}

		list.add(a);
	}

	void showAppointments() {
		System.out.println("\n--- All Appointments ---");
		for (Appointment a : list) {
			System.out.println(a.doctor + " - " + a.patient + " - " + a.date);
		}
	}

}

public class HospitalAppointmentSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AppointmentManager manager = new AppointmentManager();

		while (true) {
			System.out.println("\n--- Hospital Appointment System ---");
			System.out.println("1. Book Appointment");
			System.out.println("2. View Appointments");
			System.out.println("3. Exit");
			System.out.println("Choose option: ");

			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				System.out.println("Enter Doctor Name");
				String doctor = scan.nextLine();

				System.out.println("Enter Patient Name");
				String patient = scan.nextLine();

				System.out.println("Enter Date (ex: YYYY-MM-DD)");
				String date = scan.nextLine();

				try {

					manager.book(new Appointment(doctor, patient, date));
					System.out.println("Appointment booked successfully!");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 2:
				manager.showAppointments();
				break;
			case 3:
				System.out.println("Exiting...");
				scan.close();
				System.out.println("Program Ended.");
				return;
			default:
				System.out.println("Invalid option!");
			}
		}
	}

}
