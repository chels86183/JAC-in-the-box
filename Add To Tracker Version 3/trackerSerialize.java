
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
//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.ArrayList;


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

class View implements Serializable{
    public String type;
    //public ArrayList arrayName;
    
    //public String findDate;
    public boolean found = false; 

    public View(String t){
        type = t;
        //arrayName = array;
    }

    public String getType() {return type;}
    //public ArrayList getArray() {return arrayName;}

    public void setType(String userType) {type = userType;}
    //public void setArray(ArrayList userArray){arrayName = userArray;}

    //public boolean found(String)

    //public String toString(){return arrayName;} --> doesn't workw
}

