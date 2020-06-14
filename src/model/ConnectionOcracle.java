package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionOcracle {
	private static Connection connection;
	
	public ConnectionOcracle() {
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Order", "root", "");
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionOcracle.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
