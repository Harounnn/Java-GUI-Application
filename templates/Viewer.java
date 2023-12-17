package templates;

import templates.Menu;
import db.DataIngestor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Viewer extends JFrame {
    public Viewer() {
        // Set the title of the window
        setTitle("Students.info Viewer");

        JLabel titleLabel = new JLabel("Welcome to Students.info Viewer !");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setPreferredSize(new Dimension(300, 80));

        // Create column names
        String[] columnNames = {"ID", "Name", "Age", "Degree", "Club"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable dataTable = new JTable(tableModel);

        // Create a table with the data and column names
        dataTable = DataIngestor.fetchDataFromDatabase(tableModel, dataTable);

        // Create a scroll pane to display the table
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 600));

        JButton returnButton = new JButton("Return to Main Menu");
        Dimension buttonSize = new Dimension(60, 60);
        returnButton.setPreferredSize(buttonSize);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(returnButton, BorderLayout.SOUTH);

        // Add the scroll pane to the content pane of the window
        getContentPane().add(mainPanel);

        // Set the fixed size of the window
        setSize(800, 400);

        // Fix the window size
        setResizable(false);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window to be visible
        setVisible(true);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when Button 1 is clicked
                if(e.getSource() == returnButton){
                    dispose();
                    Menu mainMenu = new Menu();
                }
                System.out.println("Returned to main menu !");
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of the TableExample class
        Viewer viewerwindow = new Viewer();
    }
}

