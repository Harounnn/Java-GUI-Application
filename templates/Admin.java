package templates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame {

    private JTextField idField, column1Field, column2Field, column3Field, column4Field;

    public Admin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        initComponents();

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

    private void initComponents() {
        setTitle("Students.info Admin");

        JLabel titleLabel = new JLabel("Welcome to Students.info Admin !");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setPreferredSize(new Dimension(300, 80));

        // Text Fields
        idField = new JTextField(10);
        column1Field = new JTextField(10);
        column2Field = new JTextField(10);
        column3Field = new JTextField(10);
        column4Field = new JTextField(10);

        // Buttons
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton returnButton = new JButton("Return to Home Page");

        // Layout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addFieldWithLabel(inputPanel, gbc, "ID:", idField, 0, 0);
        addFieldWithLabel(inputPanel, gbc, "Name:", column1Field, 1, 0);
        addFieldWithLabel(inputPanel, gbc, "Age:", column2Field, 2, 0);
        String[] degrees = {"BD","IM","CM","AV","JV","Engineering","Masters"}; 
        addDropBoxWithLabel(inputPanel, gbc, "Degree:", new JComboBox<>(degrees), 3, 0);
        String[] clubs = {"IMC","J2i","Spark","Orenda JE","LOG",null}; 
        addDropBoxWithLabel(inputPanel, gbc, "Club:", new JComboBox<>(clubs), 4, 0);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(insertButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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

    private void addFieldWithLabel(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField, int gridy, int gridx) {
        gbc.gridy = gridy;
        gbc.gridx = gridx;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx++;
        panel.add(textField, gbc);
    }

    private void addDropBoxWithLabel(JPanel panel, GridBagConstraints gbc, String labelText, JComboBox comboBoxField, int gridy, int gridx) {
        gbc.gridy = gridy;
        gbc.gridx = gridx;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx++;
        panel.add(comboBoxField, gbc);
    }

    public static void main(String[] args) {
        new Admin();
    }
}

