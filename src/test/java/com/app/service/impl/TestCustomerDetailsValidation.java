package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCustomerDetailsValidation {

	@Test
	void testIsValidId() {
		assertEquals(false, CustomerDetailsValidation.IsValidId(12), "Id must be greater than 100");
		assertEquals(false, CustomerDetailsValidation.IsValidId(1), "Id must be greater than 100");
		assertEquals(false, CustomerDetailsValidation.IsValidId(20), "Id must be greater than 100");
		assertEquals(true, CustomerDetailsValidation.IsValidId(103), "Valid id");
		assertEquals(false, CustomerDetailsValidation.IsValidId(1111), "Id must be less than 1000");
		assertEquals(false, CustomerDetailsValidation.IsValidId(1222), "Id must be less than 1000");
		assertEquals(false, CustomerDetailsValidation.IsValidId(13), "Id must be greater than 100");
	}

	@Test
	void testIsValidFirstName() {
		assertEquals(true, CustomerDetailsValidation.IsValidFirstName("Himanshu"), "Valid First Name");
		assertEquals(true, CustomerDetailsValidation.IsValidFirstName("Manish"), "Valid First Name");
		assertEquals(true, CustomerDetailsValidation.IsValidFirstName("Ravi"), "Valid First Name");
		assertEquals(false, CustomerDetailsValidation.IsValidFirstName("RAvi@!"), "Invalid First Name");
		assertEquals(false, CustomerDetailsValidation.IsValidFirstName("Himanshu12"), "Invalid First Name");
		assertEquals(false, CustomerDetailsValidation.IsValidFirstName("Nikhil46"), "Invalid First Name");

	}

	@Test
	void testIsValidLastName() {
		assertEquals(false, CustomerDetailsValidation.IsValidLastName("Sha3133"), "Invalid Last Name");
	}

	@Test
	void testIsValidEmail() {
		assertEquals(true, CustomerDetailsValidation.IsValidEmail("hrj7292@gmail.com"), "Valid Email id");
	}

}
