package com.epam.library.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.command.ICommand;
import com.epam.library.command.NoCommand;
import com.epam.library.command.RenameBookCommand;
import com.epam.library.command.ShowLessThanThreeCommand;
import com.epam.library.command.ShowMoreThanOneCommand;
import com.epam.library.exeption.ServiceException;

public class Controller {
	
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);
	private  Map<Integer, ICommand> commandsMap;
	
	{
		commandsMap = new HashMap<>();
		commandsMap.put(1, new RenameBookCommand());
		commandsMap.put(2, new ShowLessThanThreeCommand());
		commandsMap.put(3, new ShowMoreThanOneCommand());
	}
	
	public Controller() throws ServiceException{
		doLogic();
	}
	
	private void doLogic() throws ServiceException{
		String ch = "y";
		Scanner scanInt = null, scanString = null;
		do{
			LOGGER.info("Please enter your choise: \nFor rename book operation - press 1; \n"
					+ "Choose employess hwo've read more than one book - press 2; \n"
					+ "Choose employess hwo've read less than three books - press 3; ");
			scanInt = new Scanner(System.in);
			if(scanInt.hasNextInt()){
				int choise = scanInt.nextInt();
				getCommand(choise);
				LOGGER.info("Please type 'y' if you want continue, or any key to quit.");
				scanString = new Scanner(System.in);
				ch = scanString.nextLine();
			}else{
				LOGGER.info("Please chek your data input.");
			}
		}while(ch.equals("y"));
		scanInt.close();
		scanString.close();
	}
	
	
	public void getCommand(int numOfCommand) throws ServiceException{
		if(!commandsMap.keySet().contains(numOfCommand)){
			new NoCommand().execute();
		}else{
			commandsMap.get(numOfCommand).execute();
		}
	}

}
