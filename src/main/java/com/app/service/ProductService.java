package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;

public interface ProductService {
	public List<Product> ViewAllProduct() throws BusinessException;

	public int AddProduct() throws BusinessException;

	public int AddToCart(Cart cart) throws BusinessException;
}
