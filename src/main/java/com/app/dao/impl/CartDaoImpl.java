package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CartDao;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.util.MysqlConnection;

public class CartDaoImpl implements CartDao {
	private static Logger log = Logger.getLogger(CartDaoImpl.class);

	@Override
	public List<Product> viewCart(int CustomerId) throws BusinessException {
		List<Product> ViewCart = new ArrayList<>();
		try (Connection connection = MysqlConnection.getConnection()) {
			String sql = "select p.productId,productName,productPrice from product p join cart c on c.productId=p.productId where CustomerId= ? Order by p.productId;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerId);
			ResultSet resultset = preparedStatement.executeQuery();
			Cart cart = new Cart();

			while (resultset.next()) {
				Product product = new Product();
				product.setProductId(resultset.getInt("productId"));
				product.setProductName(resultset.getString("productName"));
				product.setProductPrice(resultset.getDouble("productPrice"));
				ViewCart.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {

		}
		return ViewCart;
	}
}
