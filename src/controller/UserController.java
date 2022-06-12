package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.UserDAO;
import model.vo.UserVO;

public class UserController {
	
//	private UserModule userModel;
	private UserDAO userDAO;
	private UserVO userVO;
	
	public UserController() {
//		this.userModel = new UserModule();
		this.userDAO = new UserDAO();
		
	}
	
	public void index() {
		new view.Login().setVisible(true);
	}
	
	public boolean checkLogin( String username, String pass) throws SQLException {

		try {
			userVO = this.userDAO.getUser(username);

			if(userVO != null){
				if(userVO.getUsername().equals(username) && userVO.getPassword().equals(pass)) {
					return true;
				}
			}
		}catch(SQLException ex) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
		
	}
}
