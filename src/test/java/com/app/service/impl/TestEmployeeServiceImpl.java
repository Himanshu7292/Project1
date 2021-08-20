package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;

class TestEmployeeServiceImpl {
	EmployeeServiceImpl esi = new EmployeeServiceImpl();

	@Test
	void testEmployeeLogin() {
		try {
			assertEquals(1, esi.EmployeeLogin(72920, "qwerty12345"), "login Successfully");
			assertEquals(0, esi.EmployeeLogin(7220, "qwert12345"), "Wrong Employee Credentials");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
