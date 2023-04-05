package jacTracker;

//import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class editTracker {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Let's edit the tracker. Choose the number of what you would like to change.\n1. Assignment\n2. Appointment\n3. Event");
		String edit = sc.nextLine();

		File myFile = new File("assignments.txt");
		Scanner fileIn = new Scanner(myFile);
		String assignments = "";
		
		if(edit.equals("1")){
			
			System.out.println("What would you like to change from your assignments. Choose the number below.\n1. Name\n2. Description\n3. Class Name\n4. Due Date");
			String change = sc.nextLine();
			String details = "";
			if(change.equals("1")) {
				details = "Assignment Name: ";
				System.out.println("Type in the name.");
				change = details + sc.nextLine();
			}
			if(change.equals("2")) {
				details = "Desciption: " ;
				System.out.println("Type in the Description");
				change = details + sc.nextLine();
			}
			if(change.equals("3")) {
				details = "Class Name: ";
				System.out.println("Type the class name.");
				change = details + sc.nextLine();
			}
			if(change.equals("4")) {
				details = "Due Date: ";
				System.out.println("Type in the Due Date");
				change = details + sc.nextLine();
			}
			
			System.out.println("What would you like to change it to? ");
			String changeTo = details + sc.nextLine();
			
			
			FileWriter update = new FileWriter("AssignmentsUpdated.txt", false);
			
			while(fileIn.hasNextLine()) {
				
				String line = fileIn.nextLine();
				assignments = assignments+"\n"+line;
	
				if(line.equals(change)) {
					assignments = assignments.replace(line, changeTo);
				}
				
			}

			update.write(assignments);
			fileIn.close();
			update.close();
			
			
			
		}
		
		File apptFile = new File("appointments.txt");
		Scanner apptFileIn = new Scanner(apptFile);
		String appointments = "";
		
		if(edit.equals("2")){
			
			System.out.println("What would you like to change from your appointments. Choose the number below.\n1. Doctor\n2. Location\n3. Date\n4. Time");
			String change = sc.nextLine();
			String details = "";
			if(change.equals("1")) {
				details = "Doctor: ";
				System.out.println("Type in the name of the Dr.");
				change = details + sc.nextLine();
			}
			if(change.equals("2")) {
				details = "Location: " ;
				System.out.println("Type in the location.");
				change = details + sc.nextLine();
			}
			if(change.equals("3")) {
				details = "Date: ";
				System.out.println("Type the date.");
				change = details + sc.nextLine();
			}
			if(change.equals("4")) {
				details = "Time: ";
				System.out.println("Type in the time.");
				change = details + sc.nextLine();
			}
			
			System.out.println("What would you like to change it to? ");
			String changeTo = details + sc.nextLine();
			
			
			//FileWriter update = new FileWriter("AppointmentsUpdated.txt", true);
			//File.createNewFile();
		
			FileWriter update = new FileWriter("AppointmentsUpdated.txt", false);
			
			while(apptFileIn.hasNextLine()) {
				
				String line = apptFileIn.nextLine();
				appointments = appointments+"\n"+line;
	
				if(line.equals(change)) {
					appointments = appointments.replace(line, changeTo);
				}
				
			}

			update.write(appointments);
			apptFileIn.close();
			update.close();
			
			
			
		}
		
		File eventsFile = new File("events.txt");
		Scanner eventsFileIn = new Scanner(eventsFile);
		String events = "";
		
		if(edit.equals("3")){
			
			System.out.println("What would you like to change from your Events. Choose the number below.\n1. Name\n2. Location\n3. Date");
			String change = sc.nextLine();
			String details = "";
			if(change.equals("1")) {
				details = "Name: ";
				System.out.println("Type in the name of the event.");
				change = details + sc.nextLine();
			}
			if(change.equals("2")) {
				details = "Location: " ;
				System.out.println("Type in the location.");
				change = details + sc.nextLine();
			}
			if(change.equals("3")) {
				details = "Date: ";
				System.out.println("Type the date.");
				change = details + sc.nextLine();
			}
			
			System.out.println("What would you like to change it to? ");
			String changeTo = details + sc.nextLine();
			
			
			FileWriter update = new FileWriter("eventsUpdated.txt", false);
			
			while(eventsFileIn.hasNextLine()) {
				
				String line = eventsFileIn.nextLine();
				events = events+"\n"+line;
	
				if(line.equals(change)) {
					events = events.replace(line, changeTo);
				}
				
			}

			update.write(events);
			eventsFileIn.close();
			update.close();
			
			
			
		}
		
		
		sc.close();
	}
}
