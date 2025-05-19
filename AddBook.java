    package library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddBook extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JButton bt1, closeButton; // Add close button
    JPanel p1, p2, p3;
    Font f, f1;
    JTextField t1, t2, t3, t4, t5;

    AddBook() {
        super("Admin Login page");
        setLocation(450, 400);
        setSize(500, 350);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);

        l1 = new JLabel("Book Id");
        l2 = new JLabel("Book Name");
        l3 = new JLabel("Author");
        l4 = new JLabel("Publication");
        l5 = new JLabel("Quantity");
        l6 = new JLabel("Add a book");

        bt1 = new JButton("Add");
        bt1.addActionListener(this);

        // Create and configure the close button
        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LibrarianSection().setVisible(true);
                dispose(); // Close the frame
            }
        });

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        bt1.setFont(f);
        closeButton.setFont(f);

        l6.setHorizontalAlignment(JLabel.CENTER);
        l6.setForeground(Color.WHITE);
        bt1.setHorizontalAlignment(JLabel.CENTER);
        bt1.setForeground(Color.GREEN);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l6);
        p1.setBackground(Color.blue);

        closeButton.setHorizontalAlignment(JLabel.CENTER);
        closeButton.setForeground(Color.RED);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 2, 10, 10));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(l5);
        p2.add(t5);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2, 10, 10)); // Use two columns for buttons
        p3.add(bt1);
        p3.add(closeButton); // Add the close button

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String bid = t1.getText();
        String bname = t2.getText();
        String bauthor = t3.getText();
        String publication = t4.getText();
        int quantity = Integer.parseInt(t5.getText());

        if (e.getSource() == bt1) {
            try {
                connectionClass obj = new connectionClass();
                String query = "insert into Books values('" + bid + "','" + bname + "','" + bauthor + "','" + publication + "','" + quantity + "')";
                obj.stm = obj.con.createStatement();
                obj.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book added successfully");
                new LibrarianSection().setVisible(true);
                this.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        new AddBook().setVisible(true);
    }
}
