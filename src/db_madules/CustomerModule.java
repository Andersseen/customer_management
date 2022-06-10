package db_madules;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import config.DB;


public class CustomerModule {
	private Connection dbConexion = null;
	private String sql = null;
	
	private Statement dbQ;
	
	public CustomerModule() {
		this.dbConexion = new DB().getConexion();
		try {
			this.dbQ =  (Statement) this.dbConexion.createStatement();
		} catch(SQLException ex) {
			Logger.getLogger(CustomerModule.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public ResultSet getCustomers() {
		try {
			this.sql =  "SELECT * FROM customers";
			ResultSet rs = this.dbQ.executeQuery(this.sql);
			return rs;
		} catch(SQLException ex) {
			Logger.getLogger(CustomerModule.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}