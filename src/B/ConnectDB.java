package B;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB
{
    public Connection conn=null;
     public ResultSet rs=null;
    PreparedStatement pst=null;
    
     public Connection getConn(){
        
        try {
            Class.forName("org.postgresql.Driver");
            
        } catch (ClassNotFoundException ex) {}
        
      try {
        String url="jdbc:postgresql://localhost/Hotel";
        String user="postgres";
        String password="shubhampwr";
        
        
            conn=DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null,"connect");
        } catch (SQLException ex) {
            System.out.println(ex);
           
        }
       return conn;
        
  }
    
}
