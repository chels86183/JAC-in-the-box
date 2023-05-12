import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    //private int clicks = 0;
    //private JLabel label = new JLabel("Number of clicks:  0 ");
    private JFrame frame = new JFrame();

    public GUI() {
        JLabel label = new JLabel("Welcome to your very own Jac-tracker!", JLabel.CENTER);
        frame.add(label);

        // the clickable button
        JButton button1 = new JButton("Click me to start adding to your calender");
        button1.addActionListener(this);
        JButton button2 = new JButton("Click me edit your schedule ");
        button2.addActionListener(this);
        JButton button3 = new JButton("Click me view your schedule ");
        button3.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(label);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JAC-Tracker");
        frame.pack();
        frame.setVisible(true);
    }

    // // process the button clicks
    // public void actionPerformed(ActionEvent e) {
    //     clicks++;
    //     label.setText("Number of your clicks:  " + clicks);
    // }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }

    
}