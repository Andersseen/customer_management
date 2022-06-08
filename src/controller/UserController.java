package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db_madules.UserModule;

public class UserController {
	
	private UserModule userModel;
	
	public UserController() {
		this.userModel = new UserModule();
	}
	
	public void index() {
		new view.Login().setVisible(true);
	}
	
	public boolean checkLogin( String user, String pass) throws SQLException{{
//	public  boolean checkLogin( String user) throws SQLException{
	
		try {
			ResultSet rs = this.userModel.getUser(user);
			if(rs.next()){
				if(rs.getString("password").equals(pass)) {
					return true;
				}
			}
		}catch(SQLException ex) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
		
		}
	}
}
