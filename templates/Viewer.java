import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

public class Viewer extends JFrame {
    public Viewer() {
        // Set the title of the window
        setTitle("Table Example");

        JLabel titleLabel = new JLabel("Welcome to Students.info Viewer !");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setPreferredSize(new Dimension(300, 80));

        // Create sample data for the table
        Object[][] data = {
                {"John", "Doe", 25},
                {"Jane", "Smith", 30},
                {"Bob", "Johnson", 22}
        };

        // Create column names
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // Create a table with the data and column names
        JTable table = new JTable(data, columnNames);

        // Create a scroll pane to display the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(300, 600));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

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
    }

    public static void main(String[] args) {
        // Create an instance of the TableExample class
        Viewer viewerwindow = new Viewer();
    }
}

