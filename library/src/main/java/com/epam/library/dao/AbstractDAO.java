package com.epam.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.epam.library.db.DataBase;
import com.epam.library.exeption.DAOException;

public abstract class AbstractDAO<T> {
	
	private static final DataBase DB = new DataBase();
	protected Connection cn;
	
	public AbstractDAO() {
		cn = DB.getCn();
	}

	public abstract boolean insert(T t) throws DAOException;
	
	public abstract boolean update(T t) throws DAOException;
	
	public abstract List<T> select() throws DAOException;
	
	public abstract boolean delete(T t) throws DAOException;
	
	public void close(Statement st){
		try {
			if(st != null){
			st.close();
			}
		} catch (SQLException e) {
			//LOGGER.error("Unable to close statement", e);
		}
		
	}
	
}
