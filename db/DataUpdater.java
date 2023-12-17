package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DataUpdater{
    public static void insertData(int id, String name, int age, String degree, String club){
        try {
            Connection connection = DatabaseConnector.connect();

            String query = "INSERT INTO Students (ID, Name, Age, Degree, Club) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, degree);
            statement.setString(5, club);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data inserted successfully", "Database Status", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inserting data into the database", "Database Status", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void deleteData(int id) {
        try {
            // Establish a connection to the SQLite database
            Connection connection = DatabaseConnector.connect();

            // Prepare the SQL statement for deletion
            String query = "DELETE FROM Students WHERE ID = ?";
            try (
                PreparedStatement statement = connection.prepareStatement(query)) {
                // Set value from the ID text field
                statement.setInt(1, id);

                // Execute the SQL statement
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Row deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No rows deleted. Row with specified ID not found.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }

            // Close the connection
            connection.close();

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error deleting row: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}