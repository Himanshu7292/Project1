package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerService {
	public int RegisterNewCustomer(Customer customer) throws BusinessException;

	public Customer CustomerLogin(String email, String Password) throws BusinessException;
}
