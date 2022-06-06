package controller;

import db_madules.UserModule;

public class UserController {
	
	private UserModule userModel;
	
	public UserController() {
		this.userModel = new UserModule();
	}
	
	public void index() {
		new view.Login().setVisible(true);
	}

}
