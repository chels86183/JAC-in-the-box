import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class GUI3 {
    public static void main(String[] args) {
        // Define frame, label and panel
        JFrame frame = new JFrame("Jac-Tracker");
        JLabel label = new JLabel("Welcome to Jac-tracker, the one stop shop for your schedule", JLabel.CENTER);
        JPanel panel = new JPanel();
        
        // Setting for the panel
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));//30, 30, 10, 3045, 70, 45, 70
        
        // Define new buttons
        JButton button1 = new JButton("Click me to start adding to your calender");
        JButton button2 = new JButton("Click me edit your schedule ");      
        JButton button3 = new JButton("Click me view your schedule");
        
        // Add buttons to the frame (and spaces between buttons)
        panel.add(button1); 
        panel.add(button2);
        panel.add(button3);
        
        // Add the label and panel to the frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);
        
        // Settings for the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
