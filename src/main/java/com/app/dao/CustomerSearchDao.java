package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerSearchDao {

	public Customer getCustomerDetailsByCustomerId(int id) throws BusinessException;

	public Customer getCustomerDetailsByCustomerEmail(String email) throws BusinessException;

	public List<Customer> getCustomerDetailsByCustomerFirstName(String FirstName) throws BusinessException;

	public List<Customer> getCustomerDetailsByCustomerLastName(String LastName) throws BusinessException;
}
