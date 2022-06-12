package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DB {
	private static final String NAMEDB = "db_management";
	private static final String URL = "jdbc:mysql://localhost:3306/" + NAMEDB;
	private static final String USER = "root";
	private static final String PASS = "root";
	
	Connection conn=null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conect = DriverManager.getConnection(URL,USER,PASS);
			return conect;
		}catch(SQLException ex) {
			Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public void desconnect(){
		conn=null;
	}
	

}
