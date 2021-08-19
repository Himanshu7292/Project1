package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDao {
	public int RegisterNewCustomer(Customer customer) throws BusinessException;

	public Customer CustomerLogin(String email, String Password) throws BusinessException;

}
