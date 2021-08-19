package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface CartDao {
	public List<Product> viewCart() throws BusinessException;

}
