package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerSearchDao;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.util.MysqlConnection;

public class CustomerSearchDaoImpl implements CustomerSearchDao {
	private static Logger log = Logger.getLogger(CustomerSearchDaoImpl.class);

	@Override
	public Customer getCustomerDetailsByCustomerId(int id) throws BusinessException {
		Customer customer = new Customer();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Select CustomerId,CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword from customer where CustomerId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				customer.setCustomerId(id);
				customer.setCustomerFirstName(resultset.getString("CustomerFirstName"));
				customer.setCustomerLastName(resultset.getString("CustomerLastName"));
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));
			} else {
				throw new BusinessException("Entered CustomerId does not exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal Error Occured");
		}
		return customer;
	}

	@Override
	public Customer getCustomerDetailsByCustomerEmail(String email) throws BusinessException {

		Customer customer = new Customer();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Select CustomerId,CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword from customer where CustomerEmail=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				customer.setCustomerId(resultset.getInt("CustomerId"));
				customer.setCustomerFirstName(resultset.getString("CustomerFirstName"));
				customer.setCustomerLastName(resultset.getString("CustomerLastName"));
				customer.setCustomerEmail(email);
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));
			} else {
				throw new BusinessException("Entered Customer Email does not exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal Error Occured");
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerDetailsByCustomerFirstName(String FirstName) throws BusinessException {
		List<Customer> CustomerListByFirstName = new ArrayList<>();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Select CustomerId,CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword from customer where CustomerFirstName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, FirstName);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultset.getInt("CustomerId"));
				customer.setCustomerFirstName(FirstName);
				customer.setCustomerLastName(resultset.getString("CustomerLastName"));
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));
				CustomerListByFirstName.add(customer);
			}
			if (CustomerListByFirstName.size() == 0) {
				throw new BusinessException("Entered Customer FirstName does not exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal Error Occured");
		}
		return CustomerListByFirstName;
	}

	@Override
	public List<Customer> getCustomerDetailsByCustomerLastName(String LastName) throws BusinessException {
		List<Customer> CustomerListByLastName = new ArrayList<>();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Select CustomerId,CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword from customer where CustomerLastName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, LastName);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultset.getInt("CustomerId"));
				customer.setCustomerFirstName(resultset.getString("CustomerFirstName"));
				customer.setCustomerLastName(LastName);
				customer.setCustomerEmail(resultset.getString("CustomerEmail"));
				customer.setCustomerPassword(resultset.getString("CustomerPassword"));
				CustomerListByLastName.add(customer);
			}
			if (CustomerListByLastName.size() == 0) {
				throw new BusinessException("Entered Customer LastName does not exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal Error Occured");
		}
		return CustomerListByLastName;
	}

}
