package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public interface ProductDao {
	public List<Product> ViewAllProduct() throws BusinessException;

	public int AddToCart(Cart cart) throws BusinessException;

	public int AddProduct(Product product) throws BusinessException;

	public int UpdateProductPrice(Product product) throws BusinessException;
}
