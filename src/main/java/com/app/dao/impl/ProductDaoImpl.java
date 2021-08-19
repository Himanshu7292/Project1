package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductDao;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.util.MysqlConnection;

public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);

	@Override
	public List<Product> ViewAllProduct() throws BusinessException {
		List<Product> AllProductList = new ArrayList<>();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Select productId,productName,productPrice from product";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Product product = new Product();
				product.setProductId(resultset.getInt("productId"));
				product.setProductName(resultset.getString("productName"));
				product.setProductPrice(resultset.getDouble("productPrice"));
				AllProductList.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return AllProductList;
	}

	@Override
	public int AddProduct() throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int AddToCart(Cart cart) throws BusinessException {
		int c = 0;
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "Insert into cart(ProductId,CustomerId) values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, cart.getProductId());
			preparedStatement.setInt(2, cart.getCustomerId());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultset = preparedStatement.getGeneratedKeys();
				if (resultset.next()) {
					cart.setSerialNo(resultset.getInt(1));
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal Error Ocurred");
		}
		return c;
	}

}
