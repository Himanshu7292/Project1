package com.app.service.impl;

public class CustomerDetailsValidation {

	public static boolean IsValidId(int id) {
		if (id > 100 && id < 1000) {
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean IsValidFirstName(String FirstName) {
		if (FirstName != null && FirstName.matches("[A-Za-z]{3,30}")) {
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean IsValidLastName(String LastName) {
		if (LastName != null && LastName.matches("[A-Za-z]{3,30}")) {
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean IsValidEmail(String Email) {
		if (Email != null && Email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean IsValidPassword(String Password) {
		if (Password != null && Password.matches("[A-Za-z0-9]{8,24}")) {
			return true;
		}

		else {
			return false;
		}
	}
}