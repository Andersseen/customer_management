package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.CustomerDAO;
import model.dao.UserDAO;
import model.vo.CustomerVO;
import model.vo.UserVO;


public class DashboardController {
	
//	private UserModule userModele;

	private UserDAO userDAO;
	private UserVO userVO;
	
	private CustomerDAO customerDAO;
	private CustomerVO customerVO;
	
	private ArrayList<CustomerVO> customersList;
	
	public static String user = null;
	public static String userName = null;

	public DashboardController() {
//			this.userModele = new UserModule();
		this.userDAO = new UserDAO();
		this.customerDAO = new CustomerDAO();
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
	
	public  ArrayList<CustomerVO> getClients() {
		customersList = new ArrayList<CustomerVO>();
		try {
			customersList = this.customerDAO.getCustomers();

			if(customersList != null){
				return customersList;
			}
			
			return customersList;
		}catch(SQLException ex) {
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return customersList;
	}
		
}
