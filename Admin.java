/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;
import library.Index;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author kanth
 */
public class Admin extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField t1;
    JPasswordField t2;
    Admin()
    {
       super("Admin Login page");
       setLocation(450,400);
       setSize(500,200);
       
       f=new Font("Arial",Font.BOLD,25);
       f1=new Font("Arial",Font.BOLD,20);
       
       l1=new JLabel("Admin Login");
       l2=new JLabel("Name");
       l3=new JLabel("Password");
       
       bt1 = new JButton("Login");
       bt2 = new JButton("Cancel");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
        
       t1=new JTextField();
       t2=new JPasswordField();
       
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       bt1.setFont(f1);
       bt2.setFont(f1);
       t1.setFont(f1 );
       t2.setFont(f1);
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.WHITE);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       p1.setBackground(Color.ORANGE);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(3,2,10,10));
       p2.add(l2);
       p2.add(t1);
       p2.add(l3);
       p2.add(t2);
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
       
       
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
       String name=t1.getText();
       String pass=t2.getText();
       if(e.getSource()==bt1)
       {
           try
           {
               connectionClass obj=new connectionClass();
               String s="select * from admin where username='"+name+"' and password='"+pass+"'";
               ResultSet rest=obj.stm.executeQuery(s);
               if(rest.next())
               {
                   JOptionPane.showMessageDialog(null,"Login Successfull");   
                   new AdminSection().setVisible(true);
                   this.setVisible(false);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid credentials");
                   this.setVisible(false);
                   this.setVisible(true);
               }
           }
           catch(Exception ee)
           {
            ee.printStackTrace();
           }
       }
       if(e.getSource()==bt2)
       {
           Index index=new Index();
           index.setVisible(true);
          this.setVisible(false); 
       }
        
    }
    public static void main(String[] args)
    {
        new Admin().setVisible(true);
    }
}
