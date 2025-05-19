/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author kanth
 */
public class Addlibrarian extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1;
    JPanel p1,p2,p3;
    Font f,f1;
    JTextField t1,t2,t3,t4,t5,t6;
    
    Addlibrarian()
    {
        super("Librarian info input");
       setLocation(450,400);
       setSize(500,350);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Librarian name");
       l2=new JLabel("Librarian id");
       l3=new JLabel("Librarian Address");
       l4=new JLabel("Contact");
       l5=new JLabel("Email");
       l6=new JLabel("Password");
       l7=new JLabel("Enter details");
       bt1 = new JButton("Add");
       
       bt1.addActionListener(this);
       
       t1=new JTextField();
       t2=new JTextField();
       t3=new JTextField();
       t4=new JTextField();
       t5=new JTextField();
       t6=new JTextField();
       
       
       
       l1.setFont(f);
       l2.setFont(f);
       l3.setFont(f);
       l4.setFont(f);
       l5.setFont(f);
       t1.setFont(f);
       t2.setFont(f);
       t3.setFont(f);
       t4.setFont(f);
       t5.setFont(f);
       l6.setFont(f);
       t6.setFont(f);
      
       bt1.setFont(f);
       
       l7.setHorizontalAlignment(JLabel.CENTER);
       l7.setForeground(Color.WHITE);
       bt1.setHorizontalAlignment(JLabel.CENTER);
       bt1.setForeground(Color.ORANGE);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l6);
       p1.setBackground(Color.ORANGE);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(6,2,10,10));
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
       p2.add(l6);
       p2.add(t6);
       
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));
       p3.add(bt1);
       //p1.setBackground(Color.ORANGE);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
       add(p3,"South");
    }

    
    @Override
    public void actionPerformed(ActionEvent e)
    {
       String ename=t1.getText();
       int eid=Integer.parseInt(t2.getText());
       String address=t3.getText();
       String contact = t4.getText();
       String email=t5.getText();
       String password=t6.getText();

       
    
       if(e.getSource()==bt1)
       {
           try
           {
               connectionClass obj=new connectionClass();
               String query="insert into Librarianinfo values('"+ename+"','"+eid+"','"+address+"','"+contact+"','"+email+"')";
               obj.stm=obj.con.createStatement();
               obj.stm.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee added succesfully");
               String query2="insert into Librarian values('"+eid+"','"+password+"')";
               obj.stm=obj.con.createStatement();
               obj.stm.executeUpdate(query2);
               new AdminSection().setVisible(true);
               this.setVisible(false);
           }
           catch(Exception ee)
           {
            ee.printStackTrace();
           }
       }
    }
     public static void main(String[] args)
    {
        new Addlibrarian().setVisible(true);
    }
    
}
