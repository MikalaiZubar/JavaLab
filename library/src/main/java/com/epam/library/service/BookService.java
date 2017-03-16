package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.exeption.DAOException;
import com.epam.library.exeption.ServiceException;

public class BookService {
	
	public void renameBook(String oldName, String newName) throws ServiceException{
		BookDAO bDao = new BookDAO();
		try {
			bDao.renameBrief(oldName, newName);
		} catch (DAOException e) {
			throw new ServiceException("Error! Unable to retrieve the book.", e);
		}
	}

}
