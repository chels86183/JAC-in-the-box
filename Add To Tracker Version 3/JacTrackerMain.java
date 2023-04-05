import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;


public class JacTrackerMain{
    
    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Task>> CollectionAssignments = new ArrayList<ArrayList<Task>>();        
        Scanner s = new Scanner(System.in);

        ArrayList<Task> assignments = new ArrayList<Task>(); //initiates a new array every time

        // WELCOME MENU //

            System.out.println("---------------------------------------------\n\n\t Welcome to the JAC Tracker! \n\n---------------------------------------------\n\nThe JAC Tracker is designed to make your life a little more organized to keep you on track!");
            System.out.println("\nWhat would you like to do?\n\t1. Add a task or event.\n\t2. Edit a task or event.\n\t3. Delete a task or event.\n\t4. View by Date");
            System.out.println("Select from the listed options: Add, Edit, Delete or View.");
            String c1 = s.nextLine();

            // ADDING A TASK //
            

                if (c1.equals("Add") || c1.equals("add") || c1.equals("1")){
                    
                    System.out.println("\n-------------------------------------\n\nYou chose to add a task. \nPlease note that because you are adding information, you will be prompted for a few details. \n\tThere are certain fields you are required to answer.\n\tFailing to answer the fields with an '*' will result in having to fill things out all over again.");
            
                    /* Attempt to print Object to a text file 
                        -- ERROR: prints the specific object itself, not its data
                            -- SOLUTION: using FileInputStream to read the FileOutputStream
                    */

                    System.out.println("\nWhat task would you like to add?\n\t1. Assignment\n\t2. Appointment\n\t3. Event\nEnter an option.");
                    String c2 = s.nextLine();

                    String addTask = "yes";

                    while(addTask.equals("yes") || addTask.equals("Yes") || addTask.equals("Y") || addTask.equals("y")) {
                        String grammar = "yes";
                        String complete = "no";
                        
                        while(grammar.equals("yes")) {
                            if(c2.equals("Assignment") || c2.equals("assignment") || c2.equals("1")) {
                                while(complete.equals("no")){
                                    System.out.println("\n-------------------------------------\n\nEnter in the details below:");
                                    Task assignment = new Task("", "", "", "");

                                    System.out.println("\n* Assignment name: ");
                                    String userName = s.nextLine();
                                    assignment.setTaskName(userName);
                            
                                    System.out.println("\n* Assignment description: ");
                                    String userDesc = s.nextLine();
                                    assignment.setTaskDesc(userDesc);

                                    System.out.println("\nClass name: ");
                                    String userClass = s.nextLine();
                                    assignment.setTaskClass(userClass);

                                    System.out.println("\n* Due date in MONTH/DAY/YEAR format: ");
                                    System.out.println("Month: ");
                                        int month = s.nextInt();
                                        s.nextLine();
                                    System.out.println("Day: ");
                                        int day = s.nextInt();
                                        s.nextLine();
                                    System.out.println("Year: ");
                                        int year = s.nextInt();
                                        s.nextLine();
                                    String userDue = month + "/" + day + "/" + year;
                                    assignment.setTaskDue(userDue);

                                    System.out.println("\n");

                                    if((!assignment.checkValid(assignment.name)) || (!assignment.checkValid(assignment.description)) || (!assignment.checkValid(assignment.dueDate))) {
                                        System.out.println("You did not complete all valid fields.");
                                    } else {
                                        assignments.add(assignment); // adds assignment to an array
                                        CollectionAssignments.add(assignments);


                                        // Writing the object into a text file (will be unreadable) //
                                        try {
                                            FileOutputStream fos = new FileOutputStream("assignments.txt");
                                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                                            oos.writeObject(assignments); //rewriting the array to the file everytime
                                            oos.flush();
                                            oos.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } 
                
                                        // Reading the text file to a readable format 
                                        // Reminder that this is what prints out every time to demonstrate what is being inputted and entered
                                        try {
                                            FileInputStream fis = new FileInputStream("assignments.txt");
                                            ObjectInputStream ois = new ObjectInputStream(fis);
                
                                            ArrayList<Task> assignments2 = (ArrayList<Task>) ois.readObject();
                                            ois.close();
                                            System.out.println(assignments2.toString());
                                        } catch (IOException | ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }

                                        complete = "yes";
                                        grammar = "no";
                                        //System.out.println(assignments);
                                        // Prompts user if they want to add another task //
                                        if(complete.equals("yes") && grammar.equals("no")) {
                                            System.out.println("\nTask successfully added!\nWould you like to add another task?");
                                            addTask = s.nextLine();
                                                if(addTask.equals("yes")|| addTask.equals("Yes") || addTask.equals("yeah") || addTask.equals("Yeah") || addTask.equals("y")) {
                                                    System.out.println("What task would you like to add: Assignment, Appointment or Event.");
                                                    c2 = s.nextLine();
                                                } else {
                                                    System.out.println("\n\n-------------------------------------\n\nHave a good day and thanks for using the JAC Tracker!\n\n-------------------------------------");
                                                }
                                            }
                                        }         
                                    }
                                }

                                // ADDING AN APPOINTMENT //
                                else if (c2.equals("appointment") || c2.equals("Appointment") || c2.equals("2")) {
                                    complete = "no";
                                    ArrayList<Appointment> appointments = new ArrayList<Appointment>();

                                    while(complete.equals("no")) {
                                        System.out.println("\n-------------------------------------\n\nEnter in the details below:");
                                        Appointment appointment = new Appointment("", "", "", "");
    
                                        System.out.println("\n* Appointment type: ");
                                        String userApt = s.nextLine();
                                        appointment.setAptName(userApt);
                                
                                        System.out.println("\nLocation: ");
                                        String userLocation = s.nextLine();
                                        appointment.setLocation(userLocation);
    
                                        System.out.println("\n* Date in MONTH/DAY/YEAR format: ");
                                        System.out.println("Month: ");
                                            int month = s.nextInt();
                                            s.nextLine();
                                        System.out.println("Day: ");
                                            int day = s.nextInt();
                                            s.nextLine();
                                        System.out.println("Year: ");
                                            int year = s.nextInt();
                                            s.nextLine();
                                        String userDate = month + "/" + day + "/" + year;
                                        appointment.setDate(userDate);

                                        System.out.println("* Time in HR:MIN:AM/PM format: ");
                                        System.out.println("Hour: ");    
                                            int hour = s.nextInt();
                                            s.nextLine();
                                        System.out.println("Minutes: ");
                                            int minutes = s.nextInt();
                                            s.nextLine();
                                        System.out.println("AM or PM: ");
                                            String ampm = s.nextLine();
                                        String userTime = hour + ":" + minutes + " " + ampm;
                                        appointment.setTime(userTime);
    
                                        System.out.println("\n");

                                        if((!appointment.checkValid(appointment.aptName)) || (!appointment.checkValid(appointment.date)) || (!appointment.checkValid(appointment.time))) {
                                            System.out.println("You did not complete all valid fields.");
                                        } else {
                                            appointments.add(appointment);
    
                                            // Writing the object into a text file (will be unreadable) //
                                            try {
                                                FileOutputStream fos = new FileOutputStream("appointments.txt");
                                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                    
                                                oos.writeObject(appointments);
                                                oos.flush();
                                                oos.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } 
                    
                                            // Reading the text file to a readable format //
                                            try {
                                                FileInputStream fis = new FileInputStream("appointments.txt");
                                                ObjectInputStream ois = new ObjectInputStream(fis);
                    
                                                ArrayList<Appointment> appointments2 = (ArrayList<Appointment>) ois.readObject();
                                                ois.close();
                                                System.out.println(appointments2.toString());
                                            } catch (IOException | ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }

                                            complete = "yes";
                                            grammar = "no";
    
                                            if(complete.equals("yes") && grammar.equals("no")) {
                                                System.out.println("\nAppointment successfully added!\nWould you like to add another task?");
                                                addTask = s.nextLine();
                                                    if(addTask.equals("yes")|| addTask.equals("Yes") || addTask.equals("yeah") || addTask.equals("Yeah") || addTask.equals("y")) {
                                                        System.out.println("What task would you like to add: Assignment, Appointment or Event.");
                                                        c2 = s.nextLine();
                                                    } else {
                                                        System.out.println("\n\n-------------------------------------\n\nHave a good day and thanks for using the JAC Tracker!\n\n-------------------------------------");
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // ADDING AN EVENT //
                                    else if (c2.equals("event") || c2.equals("Event") || c2.equals("3")) {
                                        complete = "no";
                                        ArrayList<Event> events = new ArrayList<Event>();

                                        while(complete.equals("no")) {
                                            System.out.println("\n-------------------------------------\n\nEnter in the details below:");
                                            Event event = new Event("", "", "", "");
        
                                            System.out.println("\n* Event name: ");
                                            String userEvent = s.nextLine();
                                            event.setEventName(userEvent);
                                    
                                            System.out.println("\nEvent location: ");
                                            String userLocation = s.nextLine();
                                            event.setLocation(userLocation);
        
                                            System.out.println("\n* Date in MONTH/DAY/YEAR format: ");
                                            System.out.println("Month: ");
                                                int month = s.nextInt();
                                                s.nextLine();
                                            System.out.println("Day: ");
                                                int day = s.nextInt();
                                                s.nextLine();
                                            System.out.println("Year: ");
                                                int year = s.nextInt();
                                                s.nextLine();
                                            String userDate = month + "/" + day + "/" + year;
                                            event.setDate(userDate);
    
                                            System.out.println("* Time in HR:MIN:AM/PM format: ");
                                            System.out.println("Hour: ");    
                                                int hour = s.nextInt();
                                                s.nextLine();
                                            System.out.println("Minutes: ");
                                                int minutes = s.nextInt();
                                                s.nextLine();
                                            System.out.println("AM or PM: ");
                                                String ampm = s.nextLine();
                                            String userTime = hour + ":" + minutes + " " + ampm;
                                            event.setTime(userTime);
        
                                            System.out.println("\n");

                                            if((!event.checkValid(event.event)) || (!event.checkValid(event.date)) || (!event.checkValid(event.time))) {
                                                System.out.println("You did not complete all valid fields.");
                                            } else {
                                                events.add(event);
        
                                                // Writing the object into a text file (will be unreadable) //
                                                try {
                                                    FileOutputStream fos = new FileOutputStream("events.txt");
                                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                        
                                                    oos.writeObject(events);
                                                    oos.flush();
                                                    oos.close();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                } 
                        
                                                // Reading the text file to a readable format //
                                                try {
                                                    FileInputStream fis = new FileInputStream("events.txt");
                                                    ObjectInputStream ois = new ObjectInputStream(fis);
                        
                                                    ArrayList<Event> events2 = (ArrayList<Event>) ois.readObject();
                                                    ois.close();
                                                    System.out.println(events2.toString());
                                                } catch (IOException | ClassNotFoundException e) {
                                                    e.printStackTrace();
                                                }
    
                                                complete = "yes";
                                                grammar = "no";

                                                if(complete.equals("yes") && grammar.equals("no")) {
                                                    System.out.println("\nEvent successfully added!\nWould you like to add another task?");
                                                    addTask = s.nextLine();
                                                        if(addTask.equals("yes")|| addTask.equals("Yes") || addTask.equals("yeah") || addTask.equals("Yeah") || addTask.equals("y")) {
                                                            System.out.println("What task would you like to add: Assignment, Appointment or Event.");
                                                            c2 = s.nextLine();
                                                        } else {
                                                            System.out.println("\n\n-------------------------------------\n\nHave a good day and thanks for using the JAC Tracker!\n\n-------------------------------------");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("\n\n-------------------------------------\n\nHm... that doesn't seem to be an option! Sorry!");
                                            System.out.println("Here are the options again!\n\t1. Assignment\n\t2. Appointment\n\t3. Event");
                                            System.out.println("\nWhat task would you like? ");
                                            c2 = s.nextLine();

                                        }
                                    }
                                }
                            }
                            
                            if(c1.equals("View") || c1.equals("view") || c1.equals("4")){
                                //System.out.println("Hello World this prints! yayy");
                                System.out.println(assignments);
                                //View sneakpeak = new View("", empty);

                                // View sneakpeak = new View("");

                                // System.out.println("What would you like to view?\n\t1. Assignments\n\t2. Appointments\n\t3. Events");
                                // String userType = s.nextLine();
                                // sneakpeak.setType(userType);

                                // if(sneakpeak.type.equals("Assignment") || sneakpeak.type.equals("assignment") || (sneakpeak.type.equals("1"))){
                                //     //System.out.println("yay");
                                //     for(int item = 0; item < CollectionAssignments.size(); item++){
                                //         System.out.println(CollectionAssignments.get(item));
                                //         //System.out.println("Hello World");
                                //     }

                                    // try {
                                    //     FileInputStream fis = new FileInputStream("assignments.txt");
                                    //     ObjectInputStream ois = new ObjectInputStream(fis);
            
                                    //     ArrayList<Task> assignments2 = (ArrayList<Task>) ois.readObject();
                                    //     ois.close();
                                    //     System.out.println(assignments2.toString());
                                    // } catch (IOException | ClassNotFoundException e) {
                                    //     e.printStackTrace();
                                    // }
                                    //System.out.println(assignments);

                                    
                                }
                            }
                            //s.close();
                        }
                        
                    
                    
                    
                
