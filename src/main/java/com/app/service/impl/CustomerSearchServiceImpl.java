package com.app.service.impl;

import java.util.List;

import com.app.dao.CustomerSearchDao;
import com.app.dao.impl.CustomerSearchDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerSearchService;

public class CustomerSearchServiceImpl implements CustomerSearchService {
	private CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();

	@Override
	public Customer getCustomerDetailsByCustomerId(int id) throws BusinessException {
		Customer customer = null;
		if (id < 100 || id > 1000) {
			throw new BusinessException("Invalid Customer Id" + id);
		} else {
			customer = customerSearchDao.getCustomerDetailsByCustomerId(id);
		}
		return customer;
	}

	@Override
	public Customer getCustomerDetailsByCustomerEmail(String email) throws BusinessException {
		Customer customer = null;
		if (!CustomerDetailsValidation.IsValidEmail(email)) {
			throw new BusinessException("Entered email is invalid");
		} else {
			customer = customerSearchDao.getCustomerDetailsByCustomerEmail(email);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerDetailsByCustomerFirstName(String FirstName) throws BusinessException {
		List<Customer> customerListByFirstName = null;
		if (CustomerDetailsValidation.IsValidFirstName(FirstName)) {
			customerListByFirstName = customerSearchDao.getCustomerDetailsByCustomerFirstName(FirstName);
		} else {
			throw new BusinessException("Invalid First Name");
		}
		return customerListByFirstName;
	}

	@Override
	public List<Customer> getCustomerDetailsByCustomerLastName(String LastName) throws BusinessException {
		List<Customer> customerListByLastName = null;
		if (CustomerDetailsValidation.IsValidLastName(LastName)) {
			customerListByLastName = customerSearchDao.getCustomerDetailsByCustomerLastName(LastName);
		} else {
			throw new BusinessException("Invalid First Name");
		}
		return customerListByLastName;
	}

}
