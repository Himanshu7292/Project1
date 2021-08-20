package com.app.dao;

import com.app.exception.BusinessException;

public interface EmployeeDao {
	public int EmployeeLogin(int EmpId, String EmpPassword) throws BusinessException;

}
