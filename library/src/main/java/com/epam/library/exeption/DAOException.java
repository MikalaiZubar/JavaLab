package com.epam.library.exeption;


public class DAOException extends Exception{
	
	private static final long serialVersionUID = -3541078808908991518L;

	public DAOException(){
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Throwable exception){
        super(message, exception);
    }

    public DAOException(Throwable exception){
        super(exception);
    }
    
    
}
