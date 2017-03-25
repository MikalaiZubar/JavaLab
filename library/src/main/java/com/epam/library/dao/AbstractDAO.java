package com.epam.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.epam.library.db.DataBase;
import com.epam.library.db.DataBaseEnum;
import com.epam.library.exeption.DAOException;

public abstract class AbstractDAO<T> {
	
	protected static Connection cn;
	

	public AbstractDAO() {
		DataBase db = DataBase.getDataBase();
		cn = db.getCn();
	}

	//for ENUM based app
	/*
	public AbstractDAO() {
		DataBaseEnum db = DataBaseEnum.DATABASE;
		cn = db.getCn();
	}
	*/
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
