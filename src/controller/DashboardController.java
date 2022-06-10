package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import db_madules.UserModule;


public class DashboardController {
	
	private UserModule userModele;
	
	public static String user = null;
	public static String userName = null;

	public DashboardController() {
		this.userModele = new UserModule();
	}
	
	public void index(String user) {
		try {
			ResultSet rs = this.userModele.getUser(user);
			
			if(rs.next()) {
				DashboardController.user = user;
				DashboardController.userName = rs.getNString("name");
			}
			
			new view.Dashboard().setVisible(true);

		}catch(SQLException ex) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
		
}
