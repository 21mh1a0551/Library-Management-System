package library;

import java.sql.*;
public class connectionClass 
{
      Connection con;
      Statement stm;
      connectionClass()
      {
          try
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Manu@1012");
              stm=con.createStatement();
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
      }
      public static void main(String[] args)
      {
           new connectionClass();
      }
}

