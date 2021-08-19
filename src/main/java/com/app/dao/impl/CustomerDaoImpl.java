package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDao;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.util.MysqlConnection;

public class CustomerDaoImpl implements CustomerDao {
	private static Logger log = Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public int RegisterNewCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Insert into customer(CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, customer.getCustomerFirstName());
			preparedStatement.setString(2, customer.getCustomerLastName());
			preparedStatement.setString(3, customer.getCustomerEmail());
			preparedStatement.setString(4, customer.getCustomerPassword());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultset = preparedStatement.getGeneratedKeys();
				if (resultset.next()) {
					customer.setCustomerId(resultset.getInt(1));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error Occured");
		}
		return c;
	}

	@Override
	public Customer CustomerLogin(String email, String Password) throws BusinessException {
		List<Customer> logedCustDetails = new ArrayList<>();
		Customer customer = new Customer();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "select CustomerId,CustomerFirstName,CustomerLastName,CustomerEmail,CustomerPassword from customer where CustomerEmail=? AND CustomerPassword =? ";
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, Password);
			ResultSet resultset = preparedstatement.executeQuery();
//			resultset.first();
//			int c = resultset.getRow();
			if (resultset.next()) {
				customer.setCustomerId(resultset.getInt("CustomerId"));
				customer.setCustomerFirstName(resultset.getString("CustomerFirstName"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException();
		}
		return customer;

	}

}
