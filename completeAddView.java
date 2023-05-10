/*  
    coded by Johana Guilen and Alex Cana,
    for CS 335: Software Engineering.

    Part 1 of the JAC Tracker code.
 */

/* 
    Referenced from: https://mkyong.com/java/how-to-write-an-object-to-file-in-java/ 
    Using Serializable to read object into a text file:
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.io.Serializable;
*/

import java.io.*;
import java.util.*;

// Classes for each task type 
class Task implements Serializable {
    public String name;
    public String description;
    public String className;
    public String dueDate;
    public boolean valid = false;

    public Task (String n, String d, String c, String dd) {
        super();
        name = n;
        description = d;
        className = c;
        dueDate = dd;
    }

    public String getName() {return name;}
    public String getDesc() {return description;}
    public String getCName() {return className;}
    public String getDueDate() {return dueDate;}

    public void setTaskName(String userName) {name = userName;}
    public void setTaskDesc(String userDesc) {description = userDesc;}
    public void setTaskClass(String userClass) {className = userClass;}
    public void setTaskDue(String userDue) {dueDate = userDue;}

    public boolean checkValid(String n) {
        if (!"".equals(n)) {
            valid = true;
        }
        return valid;
    }

    public String toString() {return "Assignment Name: " + name + "\nAssignment Description: " + description + "\nClass Name: " + className + "\nDue Date: " + dueDate;}
}
class Appointment implements Serializable {
    public String aptName;
    public String location;
    public String date;
    public String time;
    public boolean valid = false;

    public Appointment (String apt, String l, String d, String t) {
        super();
        aptName = apt;
        location = l;
        date = d;
        time = t;
    }

    public String getAptName() {return aptName;}
    public String getLocation() {return location;}
    public String getDate() {return date;}
    public String getTime() {return time;}

    public void setAptName(String userApt) {aptName = userApt;}
    public void setLocation(String userLocation) {location = userLocation;}
    public void setDate(String userDate) {date = userDate;}
    public void setTime(String userTime) {time = userTime;}

    public boolean checkValid(String n) {
        if (!"".equals(n)) {
            valid = true;
        }
        return valid;
    }

    public String toString() {return "Type of appointment: " + aptName + "\nAppointment Location: " + location + "\nAppointment Date: " + date + "\nAppointment Time: " + time;}
}
class Event implements Serializable {
    public String event;
    public String location;
    public String date;
    public String time;
    public boolean valid = false;

    public Event (String e, String l, String d, String t) {
        super();
        event = e;
        location = l;
        date = d;
        time = t;
    }

    public String getEvent() {return event;}
    public String getLocation() {return location;}
    public String getDate() {return date;}
    public String getTime() {return time;}

    public void setEventName(String userEvent) {event = userEvent;}
    public void setLocation(String userLocation) {location = userLocation;}
    public void setDate(String userDate) {date = userDate;}
    public void setTime(String userTime) {time = userTime;}

    public boolean checkValid(String n) {
        if (!"".equals(n)) {
            valid = true;
        }
        return valid;
    }

    public String toString() {return "Event name: " + event + "\nEvent Location: " + location + "\nEvent Date: " + date + "\nEvent Time: " + time;}
}

// Main function (Adding a task)
class Add{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        ArrayList<Task> assignments = new ArrayList<Task>();

        // WELCOME MENU //

            System.out.println("---------------------------------------------\n\n\t Welcome to the JAC Tracker! \n\n---------------------------------------------\n\nThe JAC Tracker is designed to make your life a little more organized to keep you on track!");
            System.out.println("\nWhat would you like to do?\n\t1. Add a task or event.\n\t2. Edit a task or event.\n\t3. Delete a task or event.\n\t4. View your tasks.");
            System.out.println("Select from the listed options: Add, Edit, Delete, or View.");
            String c1 = s.nextLine();

            // ADDING A TASK //
            // ArrayList<Task> assignments = new ArrayList<Task>();

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

                                    System.out.println("\n* Assignment name: ");
                                    String userName = s.nextLine();
                            
                                    System.out.println("\n* Assignment description: ");
                                    String userDesc = s.nextLine();

                                    System.out.println("\nClass name: ");
                                    String userClass = s.nextLine();

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

                                    System.out.println("\n");

                                    Task assignment = new Task(userName, userDesc, userClass, userDue);
                                    assignment.setTaskName(userName);
                                    assignment.setTaskDesc(userDesc);
                                    assignment.setTaskClass(userClass);
                                    assignment.setTaskDue(userDue);

                                    if((!assignment.checkValid(assignment.name)) || (!assignment.checkValid(assignment.description)) || (!assignment.checkValid(assignment.dueDate))) {
                                        System.out.println("You did not complete all valid fields.");
                                    } else {
                                        assignments.add(assignment);

                                        FileWriter writer = new FileWriter("assignmentOutput.txt", true);  
                                        writer.write(assignment.getName() + "," + assignment.getDesc() + "," + assignment.getCName() + "," + assignment.getDueDate() + "\n");
                                        writer.close();

                                        // Writing the object into a text file (will be unreadable) //
                                        /* try {
                                            FileOutputStream fos = new FileOutputStream("assignments.txt");
                                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                                            oos.writeObject(assignments);
                                            oos.flush();
                                            oos.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } 
                
                                        // Reading the text file to a readable format //
                                        try {
                                            FileInputStream fis = new FileInputStream("assignments.txt");
                                            ObjectInputStream ois = new ObjectInputStream(fis);
                
                                            ArrayList<Task> assignments2 = (ArrayList<Task>) ois.readObject();
                                            ois.close();
                                            System.out.println(assignments2.toString());
                                        } catch (IOException | ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        */

                                        complete = "yes";
                                        grammar = "no";

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

                                            FileWriter writer = new FileWriter("appointmentOutput.txt", true);  
                                            writer.write(appointment.getAptName() + "," + appointment.getLocation() + "," + appointment.getDate() + "," + appointment.getTime() + "\n");
                                            writer.close();

                                            // Writing the object into a text file (will be unreadable) //
                                            /*
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
                                            */

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

                                                FileWriter writer = new FileWriter("eventsOutput.txt", true);  

                                                writer.write(event.getEvent() + "," + event.getLocation() + "," + event.getDate() + "," + event.getTime() + "\n");
                                                writer.close();
        
                                                // Writing the object into a text file (will be unreadable) //
                                                /*
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
                                                */
    
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

                            if (c1.equals("View") || c1.equals("view") || c1.equals("4")){
                                System.out.println("\n\n-------------------------------------\n\nWould you like to view assignments, appointments, or events?");
                                System.out.println("\n\t1. Assignment\n\t2. Appointment\n\t3. Event");
                                System.out.println("\nWhat would you like to edit? ");
                                String c3 = s.nextLine();

                                if (c3.equals("Assignment") || c3.equals("assignment") || c3.equals("1")) {
                                    System.out.println("\nHere is a list of your assignments:\n");

                                    /* 
                                    File file = new File("assignmentOutput.txt");
                                    Scanner ss = new Scanner(file);

                                    ss.useDelimiter("!!! ");
                                    while(ss.hasNextLine()) {
                                        System.out.println(ss.next());
                                    }
                                    ss.close();
                                    */
                                    ArrayList<Task> readingAssignments = new ArrayList<Task>();

                                    try {
                                        BufferedReader in = new BufferedReader(new FileReader("assignmentOutput.txt"));
                                        String lineText;
                                        while ((lineText = in.readLine()) != null) {
                                            // Splitting the line
                                            String[] line = lineText.split(",");
                                            readingAssignments.add(new Task(line[0], line[1], line[2], line[3]));
                                        }
                                        in.close();
                                    } catch (IOException e) {
                                        System.out.println("File read error.");
                                    }

                                    for(int i = 0; i < readingAssignments.size(); i++) {
                                        System.out.println("Assignment Name: " + readingAssignments.get(i).getName());
                                        System.out.println("Assignment Description: " + readingAssignments.get(i).getDesc());
                                        System.out.println("Class Name: " + readingAssignments.get(i).getCName());
                                        System.out.println("Due Date: " + readingAssignments.get(i).getDueDate());
                                        System.out.println("\n");
                                    }

                                    /*
                                    BufferedReader reader = new BufferedReader(new FileReader("assignmentOutput.txt"));
                                    int x = 1;
                                    // Read lines from file.
                                    while (true) {
                                        String line = reader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        String[] data = line.split("!!! ");

                                        // String description = data[1];
                                        // String cname = data[2];
                                        // String due = data[3];
                                        //System.out.println("Assignment Name: " + name + "\nAssignment Description: " + description + "\nClass Name: " + cname + "\nDue Date: " + due);
                                    
                                        String[] parts = line.split("!!!");
                                        for (String part : parts) {
                                            System.out.println(part);
                                        }
                                    }
                                    reader.close();
                                    */
                                    
                                    } 

                                    if (c3.equals("Appointments") || c3.equals("appointment") || c3.equals("2")) {
                                        System.out.println("\nHere is a list of your appointments:\n"); 

                                        ArrayList<Appointment> readingAppointments = new ArrayList<Appointment>();

                                        try {
                                            BufferedReader in = new BufferedReader(new FileReader("appointmentOutput.txt"));
                                            String lineText;
                                            while ((lineText = in.readLine()) != null) {
                                                // Splitting the line
                                                String[] line = lineText.split(",");
                                                readingAppointments.add(new Appointment(line[0], line[1], line[2], line[3]));
                                            }
                                            in.close();
                                        } catch (IOException e) {
                                            System.out.println("File read error.");
                                        }
    
                                        System.out.println(readingAppointments);
                                    }

                                    if (c3.equals("Events") || c3.equals("events") || c3.equals("3")) {
                                        System.out.println("\nHere is a list of your events:\n"); 

                                        ArrayList<Event> readingEvents = new ArrayList<Event>();

                                        try {
                                            BufferedReader in = new BufferedReader(new FileReader("eventsOutput.txt"));
                                            String lineText;
                                            while ((lineText = in.readLine()) != null) {
                                                // Splitting the line
                                                String[] line = lineText.split(",");
                                                readingEvents.add(new Event(line[0], line[1], line[2], line[3]));
                                            }
                                            in.close();
                                        } catch (IOException e) {
                                            System.out.println("File read error.");
                                        }
    
                                        System.out.println(readingEvents);
                                    }
        }
    }
}

/*
class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("TESTINGGGGGGGGG");
    }
}
*/