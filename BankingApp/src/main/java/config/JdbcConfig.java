package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConfig {
	 static Connection con; // Global Connection Object
	    public static Connection getConnection()
	    {
	        try {
	            String url = "jdbc:mysql://localhost:3306/mydata";
	            String user = "root";     
	            String pass = "Password";  
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	        }
	 
	        return con;
	    }
}
