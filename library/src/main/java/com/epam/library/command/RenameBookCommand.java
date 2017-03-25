package com.epam.library.command;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.exeption.ServiceException;
import com.epam.library.service.LibraryService;

public class RenameBookCommand implements ICommand{
	private static final Logger LOGGER = LogManager.getLogger(RenameBookCommand.class);
	
	@Override
	public void execute() throws ServiceException {
		String[] names = createBrief();
		LibraryService.renameBook(names[0], names[1]);
	}
	
	private String[] createBrief(){
		String[] briefs = new String[2];
		Scanner sc = new Scanner(System.in);
		LOGGER.info("Enter old brief");
		String oldBrief = sc.nextLine();
		briefs[0] = oldBrief;
		LOGGER.info("Enter new brief");
		String newBrief = sc.nextLine();
		briefs[1] = newBrief;
		sc.close();
		return briefs;
	}

}
