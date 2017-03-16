package com.epam.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.controller.Controller;
import com.epam.library.exeption.ServiceException;


public class App{
	
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	
    public static void main( String[] args ){
      try{
    	new Controller();
      }catch (ServiceException e) {
		LOGGER.error(e);
      }
   }
}
