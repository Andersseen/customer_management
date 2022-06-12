package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.UserDAO;
import model.vo.UserVO;


public class DashboardController {
	
//	private UserModule userModele;

	private UserDAO userDAO;
	private UserVO userVO;
	
	public static String user = null;
	public static String userName = null;

	public DashboardController() {
//			this.userModele = new UserModule();
		this.userDAO = new UserDAO();
	}
	
	public void index(String user) {
		try {
			userVO = this.userDAO.getUser(user);
			
			if(userVO != null) {
				DashboardController.user = user;
				DashboardController.userName = userVO.getName();
			}
			
			new view.Dashboard().setVisible(true);

		}catch(SQLException ex) {
			Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
		
}
