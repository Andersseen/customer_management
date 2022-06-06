package db_madules;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import config.DB;


public class UserModule {
	private Connection dbConexion = null;
	private String sql = null;
	
	private Statement dbQ;
	
	public UserModule() {
		this.dbConexion = new DB().getConexion();
		try {
			this.dbQ =  (Statement) this.dbConexion.createStatement();
		} catch(SQLException ex) {
			Logger.getLogger(UserModule.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public ResultSet getUser(String user) {
		try {
			this.sql =  "SELECT * FROM users US WHERE 1=1 AND US. `user` =" + user + "";
			ResultSet rs = this.dbQ.executeQuery(this.sql);
			return rs;
		} catch(SQLException ex) {
			Logger.getLogger(UserModule.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
