/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;
import library.EmployeeDetails;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author kanth
 */
public class AdminSection extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton bt1,bt2,bt3,bt4,bt5;
    JPanel p1,p2;
    Font f,f1;
    JTextField t1;
    JPasswordField t2;
    AdminSection()
    {
       super("Admin Section");
       setLocation(450,400);
       setSize(500,250);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       
       bt1 = new JButton("add Librarian");
       bt2 = new JButton("View Staffs");
       bt3 = new JButton("Remove member");
       bt5 = new JButton("Change Librarian Password");
       bt4 = new JButton("LogOut");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       bt3.addActionListener(this);
       bt4.addActionListener(this);
       bt5.addActionListener(this);
        
       
       
      
       bt1.setFont(f1);
       bt2.setFont(f1);
       bt3.setFont(f1);
       bt4.setFont(f1);
       bt5.setFont(f1);
      
       
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(5,1,10,8));
       p2.add(bt1);
       p2.add(bt2);
       p2.add(bt3);
       p2.add(bt5);
       p2.add(bt4);
       
       setLayout(new BorderLayout(10,10));
       add(p2,"Center");
       
       
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            new Addlibrarian().setVisible(true);
            this.setVisible(false);
            
        }
        if(e.getSource()==bt2)
        {
            System.out.println("Admin Login");
            EmployeeDetails employeeDetails = new EmployeeDetails();

        // You can then call methods or access properties of the bookDetails object
        employeeDetails.setVisible(true); 
            this.setVisible(false);
        }
        if(e.getSource()==bt3)
        {
            System.out.println("Admin Login");
            new RemoveMember().setVisible(true);
            this.setVisible(false);
            
        }
        if(e.getSource()==bt4)
        {
           new Index().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==bt5)
        {
            librarianPwdReset a=new librarianPwdReset();
            a.setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args)
    {
        new AdminSection().setVisible(true);
    }
}
