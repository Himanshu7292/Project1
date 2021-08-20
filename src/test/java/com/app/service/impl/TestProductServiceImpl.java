package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Product;

class TestProductServiceImpl {
	ProductServiceImpl psi = new ProductServiceImpl();
	Product product = null;

	@Test
	void testAddProduct() {
		product = new Product("Mobile Chargers", 399);
		try {
			assertEquals(1, psi.AddProduct(product), "Product Added successfully");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
