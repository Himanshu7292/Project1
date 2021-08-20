package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface CartService {
	public List<Product> viewCart(int CustomerId) throws BusinessException;
}
