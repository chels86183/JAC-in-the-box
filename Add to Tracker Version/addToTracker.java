package jacTracker;

import java.util.Scanner;
//import java.io.File;
import java.io.FileWriter;
//import java.io.PrintWriter;

public class addToTracker {
	
	public static void main(String[]args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("--- Welcome to the JAC Tracker!---\nThe JAC Tracker is designed to make your life a little more organized to keep you on track!");
				
		System.out.println("Here are your options:\n1.Add task or event\n2.Edit task or event\n3.Delete task or event");
		System.out.println("Select from the listed options: 1, 2, or 3.");
		String choice = sc.nextLine();
		
		if(choice.equals("1")) {
			System.out.print("Okay great let's add a task. \nPlease note that because you are adding information, you will be prompted for a few details. \nThere are certain fields you are required to answer. Failing to answer the fields with an '*' will \nresult in having to fill things out all over again. ");

			System.out.println("What task would you like to add?\n1. Assignment\n2. Appointment\n3. Social event\nEnter your choice as the number.");
			String task = sc.nextLine();
			//System.out.println("Please note that the fields with an '*' are required.");

			String complete = "no";
			
			if(task.equals("1")) {
				while(complete.equals("no")) {
					//System.out.print("You will have to answer the Assignment Name*, the Description*, and the Due Date*")
					
					System.out.println("\n\nAssignment Name*: ");
					String assignmentName = sc.nextLine();
					
					System.out.println("Description*: ");
					String description = sc.nextLine();
					
					System.out.println("Class Name: ");
					String className = sc.nextLine();
					
					System.out.println("Due Date*: Enter month as 'mm', day as 'dd', and year as 'yyyy'");
					System.out.println("Month: ");
					String month = sc.nextLine();
					System.out.println("Day: ");
					String day = sc.nextLine();
					System.out.println("Year: ");
					String year = sc.nextLine();
					String dueDate = month + "/" + day + "/" + year;
					
					if((assignmentName.equals(""))||(description.equals(""))||(dueDate.equals(""))){
						System.out.println("Don't forget to respond to all the required fields.");
					}
					else {
						//System.out.println("WOohoo this prints");
						//File assignment = new File("assignments.txt");
						FileWriter a = new FileWriter("assigments.txt", true);
						//PrintWriter a_out = new PrintWriter(a);
						a.write("Assignment Name: " + assignmentName + "\nDescription: " + description + "\nClass Name: " + className + "\nDue Date: " + dueDate + "\n\n");
						a.close();
						complete = "yes";
					}
				}
			}
			if(task.equals("2")) {
				complete = "no";
				
				while(complete.equals("no")) {
					System.out.println("Doctor Name*: ");
					String drName = sc.nextLine();
					
					System.out.println("Location: ");
					String apmtLocation = sc.nextLine();
					
					System.out.println("Date*: Enter month as 'mm', day as 'dd', and year as 'yyyy'");
					System.out.println("Month: ");
					String apmtMonth = sc.nextLine();
					System.out.println("Day: ");
					String apmtDay = sc.nextLine();
					System.out.println("Year: ");
					String apmtYear = sc.nextLine();
					String apmtDate = apmtMonth + "/" + apmtDay + "/" + apmtYear;
				
					System.out.println("Time*: Enter the time as hh:mm and then whether it's AM or PM");
					System.out.println("Hour: ");
					String hour = sc.nextLine();
					System.out.println("Minutes: ");
					String minutes = sc.nextLine();
					System.out.println("AM or PM?");
					String ampm = sc.nextLine();
					String apmtTime = hour + ":" + minutes + ":" + ampm;
			
					if((drName.equals(""))||(apmtLocation.equals(""))||(apmtDate.equals(""))||(apmtTime.equals(""))){
						System.out.println("Don't forget to respond to all the required fields.");
					}
					else {
						//System.out.println("WOohoo this prints");
						//File assignment = new File("assignments.txt");
						FileWriter a = new FileWriter("appointments.txt", true);
						//PrintWriter a_out = new PrintWriter(a);
						a.write("Doctor: " + drName + "\nLocation: " + apmtLocation + "\nDate: " + apmtDate + "\nTime: " + apmtTime + "\n\n");
						a.close();
						complete = "yes";
					}
				
				}
			}
			if(task.equals("3")) {
				System.out.println("What are we calling this event?\nName*: ");
				String eventName = sc.nextLine();
				
				System.out.println("Where will this event take place?\nLocation: ");
				String eventLocation = sc.nextLine();
				
				System.out.println("Date*: Enter month as 'mm', day as 'dd', and year as 'yyyy'");
				System.out.println("Month: ");
				String eventMonth = sc.nextLine();
				System.out.println("Day: ");
				String eventDay = sc.nextLine();
				System.out.println("Year: ");
				String eventYear = sc.nextLine();
				String eventDate = eventMonth + "/" + eventDay + "/" + eventYear;
				
				if((eventName.equals(""))||(eventLocation.equals(""))){
					System.out.println("Don't forget to respond to all the required fields.");
				}
				else {
					//System.out.println("WOohoo this prints");
					//File assignment = new File("assignments.txt");
					FileWriter a = new FileWriter("events.txt", true);
					//PrintWriter a_out = new PrintWriter(a);
					a.write("Name: " + eventName + "\nLocation: " + eventLocation + "\nDate: " + eventDate + "\n\n");
					a.close();
					complete = "yes";
				}
			}
			
		}
				
				
		sc.close();
	}

}
