package library;

import library.AdminSection;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeDetails extends JFrame {
    private JTable table;
    private Connection connection;
    private Statement statement;

    public EmployeeDetails() {
        // Set up the main frame
        setTitle("Employee Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 300);
        setSize(500, 300);

        // Create a panel for components
        JPanel panel = new JPanel(new BorderLayout());

        // Create a table to display data
        table = new JTable();
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Create a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            AdminSection adminSection = new AdminSection();
            adminSection.setVisible(true);
            dispose(); // Close the frame
        });
        panel.add(closeButton, BorderLayout.SOUTH);

        // Add the panel to the frame
        add(panel);

        fetchAndDisplayData();
    }

    public void fetchAndDisplayData() {
        try {
            // Connect to the database and retrieve data
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Manu@1012");
            statement = connection.createStatement();

            String query = "SELECT * FROM Librarianinfo";
            ResultSet resultSet = statement.executeQuery(query);

            // Create a table model to hold the data
            DefaultTableModel tableModel = new DefaultTableModel();

            // Get the column names from the result set
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Set the table model for the JTable
            table.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmployeeDetails employeeDetails = new EmployeeDetails();
                employeeDetails.setVisible(true);
            }
        });
    }
}
