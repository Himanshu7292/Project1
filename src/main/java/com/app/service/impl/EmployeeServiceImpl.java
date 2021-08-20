package com.app.service.impl;

import com.app.dao.EmployeeDao;
import com.app.dao.impl.EmployeeDaoImpl;
import com.app.exception.BusinessException;
import com.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public int EmployeeLogin(int EmpId, String EmpPassword) throws BusinessException {
		if (employeeDao.EmployeeLogin(EmpId, EmpPassword) == 1) {
			return 1;
		} else {
			return 0;
		}
	}

}
