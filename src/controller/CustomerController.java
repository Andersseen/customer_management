package controller;


import db_madules.CustomerModule;


public class CustomerController {
	
	private CustomerModule customerModele;
	
	public CustomerController() {
		this.setCustomerModele(new CustomerModule());
	}

	public CustomerModule getCustomerModele() {
		return customerModele;
	}

	public void setCustomerModele(CustomerModule customerModele) {
		this.customerModele = customerModele;
	}
	
}
