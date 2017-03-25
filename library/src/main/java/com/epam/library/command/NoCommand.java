package com.epam.library.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.exeption.ServiceException;

public class NoCommand implements ICommand{
	
	private static final Logger LOGGER = LogManager.getLogger(NoCommand.class);

	@Override
	public void execute() throws ServiceException {
		LOGGER.info("Not correct input. Please try once again.");
				
	}

}
