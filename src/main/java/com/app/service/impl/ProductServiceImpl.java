package com.app.service.impl;

import java.util.List;

import com.app.dao.ProductDao;
import com.app.dao.impl.ProductDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> ViewAllProduct() throws BusinessException {
		List<Product> AllProductList = productDao.ViewAllProduct();
		return AllProductList;
	}

	@Override
	public int AddToCart(Cart cart) throws BusinessException {

		return productDao.AddToCart(cart);
	}

	@Override
	public int AddProduct(Product product) throws BusinessException {
		if (productDao.AddProduct(product) == 1) {
			return 1;
		} else {
			throw new BusinessException("Price cannot be negative or zero");
		}
	}

	@Override
	public int UpdateProductPrice(Product product) throws BusinessException {
		if (productDao.AddProduct(product) == 1) {
			return 1;
		} else {
			throw new BusinessException("Invalid values entered....");
		}
	}

}
