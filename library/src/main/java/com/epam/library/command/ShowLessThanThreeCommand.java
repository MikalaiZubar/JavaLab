package com.epam.library.command;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.exeption.ServiceException;
import com.epam.library.service.LibraryService;

public class ShowLessThanThreeCommand implements ICommand{

	private static final Logger LOGGER = LogManager.getLogger(ShowLessThanThreeCommand.class);
	
	@Override
	public void execute() throws ServiceException {
		List<String> dataList = LibraryService.selectLessThanThree();
		for(String msg : dataList){
			LOGGER.info(msg);
		}
	}
	
}
