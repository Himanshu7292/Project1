package com.app.service.impl;

import java.util.List;

import com.app.dao.CartDao;
import com.app.dao.impl.CartDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.CartService;

public class CartServiceImpl implements CartService {
	private CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Product> viewCart(int CustomerId) throws BusinessException {
		return cartDao.viewCart(CustomerId);

	}
}
