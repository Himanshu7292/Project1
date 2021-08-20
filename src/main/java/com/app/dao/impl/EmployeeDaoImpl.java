package com.app.dao.impl;

import org.apache.log4j.Logger;

import com.app.dao.EmployeeDao;
import com.app.exception.BusinessException;

public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public int EmployeeLogin(int EmpId, String EmpPassword) throws BusinessException {

		if (EmpId == 72920 && EmpPassword.equals("qwerty12345")) {
			return 1;
		} else {
			return 0;
		}

	}

}
