package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.model.Customer;

class TestCustomerServiceImpl {

	@Test
	void testRegisterNewCustomer() {
		Customer cu1 = new Customer("Himanshu", "Sharma", "hsqv12@gmail.com", "hsqv123456");
		CustomerServiceImpl csi = new CustomerServiceImpl();
		try {
			assertEquals(1, csi.RegisterNewCustomer(cu1), "Customer created");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
