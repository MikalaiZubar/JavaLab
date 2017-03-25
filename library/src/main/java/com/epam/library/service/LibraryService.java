package com.epam.library.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.exeption.DAOException;
import com.epam.library.exeption.ServiceException;

public class LibraryService {
	
	
	public static void renameBook(String oldName, String newName) throws ServiceException{
		BookDAO bDao = new BookDAO();
		try {
			bDao.renameBrief(oldName, newName);
		} catch (DAOException e) {
			throw new ServiceException("Error! Unable to retrieve the book.", e);
		}
	}
	
	public static List<String> selectMoreThanOne() throws ServiceException{
		List<String> dataList = new ArrayList<>();
		try {
			EmployeeDAO eDao = new EmployeeDAO();
			dataList = eDao.selectMoreThanOne();
		} catch (DAOException e) {
			throw new ServiceException("Error! Can't retrieve query result.", e);
		}
		return dataList;
	}
	
	public static List<String> selectLessThanThree() throws ServiceException{
		List<String> dataList = new ArrayList<>();
		try {
			EmployeeDAO eDao = new EmployeeDAO();
			dataList = eDao.selectLessThanThree();;
		} catch (DAOException e) {
			throw new ServiceException("Error! Can't retrieve query result.", e);
		}
		return dataList;
	}

}
