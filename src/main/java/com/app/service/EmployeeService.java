package com.app.service;

import com.app.exception.BusinessException;

public interface EmployeeService {
	public int EmployeeLogin(int EmpId, String EmpPassword) throws BusinessException;
}
