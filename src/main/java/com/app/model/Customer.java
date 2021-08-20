package com.app.model;

public class Customer {
	private int CustomerId;
	private String CustomerFirstName;
	private String CustomerLastName;
	private String CustomerEmail;
	private String CustomerPassword;

	public Customer() {
		super();
	}

	public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerPassword) {
		super();
		CustomerFirstName = customerFirstName;
		CustomerLastName = customerLastName;
		CustomerEmail = customerEmail;
		CustomerPassword = customerPassword;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerFirstName() {
		return CustomerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		CustomerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return CustomerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		CustomerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return CustomerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerFirstName=" + CustomerFirstName + ", CustomerLastName="
				+ CustomerLastName + ", CustomerEmail=" + CustomerEmail + ", CustomerPassword=" + CustomerPassword
				+ "]";
	}

}
