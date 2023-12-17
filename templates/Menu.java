package templates;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public Menu() {
        // Set the title of the window
        setTitle("Students.info");

        // Create a label for the title
        JLabel titleLabel = new JLabel("Welcome to Students.info !");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setPreferredSize(new Dimension(300, 80));

        // Create buttons
        JButton button1 = new JButton("As an Admin");
        JButton button2 = new JButton("As a Viewer");

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        Dimension buttonSize = new Dimension(60, 15);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);

        // Create a panel to hold the title label and button panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the content pane of the window
        getContentPane().add(mainPanel);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the window
        setSize(800, 400);

        setResizable(false);

        // Set the window to be visible
        setVisible(true);

        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when Button 1 is clicked
                dispose();
                Admin admin = new Admin();
                System.out.println("Entered as an Admin !");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when Button 2 is clicked
                dispose();
                Viewer viewer = new Viewer();
                System.out.println("Entered as a viewer !");
            }
        });
    }
}
