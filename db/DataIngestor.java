package db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class DataIngestor {

    public static JTable fetchDataFromDatabase(DefaultTableModel tableModel, JTable dataTable){
        try {
            Connection connection = DatabaseConnector.connect();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Students";

            ResultSet resultSet = statement.executeQuery(query);

            tableModel = (DefaultTableModel) dataTable.getModel();

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                // Replace column names with actual column names
                Object[] rowData = {
                        resultSet.getString("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Age"),
                        resultSet.getString("Degree"),
                        resultSet.getString("Club")
                };
                tableModel.addRow(rowData);
            }

            dataTable = new JTable(tableModel);

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataTable;
    }
    
}
