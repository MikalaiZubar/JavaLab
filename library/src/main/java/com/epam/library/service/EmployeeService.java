package com.epam.library.service;

import com.epam.library.dao.EmployeeDAO;
import com.epam.library.exeption.DAOException;
import com.epam.library.exeption.ServiceException;

public class EmployeeService {
	
//	private static EmployeeDAO eDao = new EmployeeDAO();
	
	public void selectMoreThanOne() throws ServiceException{
		try {
			EmployeeDAO eDao = new EmployeeDAO();
			eDao.selectMoreThanOne();
		} catch (DAOException e) {
			throw new ServiceException("Error! Can't retrieve query result.", e);
		}
	}
	
	public void selectLessThanThree() throws ServiceException{
		try {
			EmployeeDAO eDao = new EmployeeDAO();
			eDao.selectLessThanThree();;
		} catch (DAOException e) {
			throw new ServiceException("Error! Can't retrieve query result.", e);
		}
	}

}
