package com.epam.library.exeption;


public class ServiceException extends Exception{
	
	private static final long serialVersionUID = -3789323543457145399L;

	public ServiceException(){
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Throwable exception){
        super(message, exception);
    }

    public ServiceException(Throwable exception){
        super(exception);
    }

}
