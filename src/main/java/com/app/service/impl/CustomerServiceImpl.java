package com.app.service.impl;

import com.app.dao.CustomerDao;
import com.app.dao.impl.CustomerDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public int RegisterNewCustomer(Customer customer) throws BusinessException {
//		if (!CustomerDetailsValidation.IsValidId(customer.getCustomerId())) {
//			throw new BusinessException("Entered Id " + customer.getCustomerId() + " is invalid");
//		}
		if (!CustomerDetailsValidation.IsValidFirstName(customer.getCustomerFirstName())) {
			throw new BusinessException("Entered first name " + customer.getCustomerFirstName() + " is invalid..");
		}
		if (!CustomerDetailsValidation.IsValidLastName(customer.getCustomerLastName())) {
			throw new BusinessException("Entered last name " + customer.getCustomerLastName() + " is invalid..");
		}
		if (!CustomerDetailsValidation.IsValidEmail(customer.getCustomerEmail())) {
			throw new BusinessException("Entered email " + customer.getCustomerEmail() + " is invalid..");
		}
		if (!CustomerDetailsValidation.IsValidPassword(customer.getCustomerPassword())) {
			throw new BusinessException("Entered password " + customer.getCustomerPassword() + " is invalid..");
		}
		return customerDao.RegisterNewCustomer(customer);
	}

	@Override
	public Customer CustomerLogin(String email, String Password) throws BusinessException {
		if (!CustomerDetailsValidation.IsValidEmail(email)) {
			throw new BusinessException("Invalid Email Format");
		}
		if (!CustomerDetailsValidation.IsValidPassword(Password)) {
			throw new BusinessException("Invalid Password");
		}

		return customerDao.CustomerLogin(email, Password);
	}

}
