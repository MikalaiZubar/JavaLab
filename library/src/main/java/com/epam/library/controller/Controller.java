package com.epam.library.controller;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.exeption.ServiceException;
import com.epam.library.service.BookService;
import com.epam.library.service.EmployeeService;

public class Controller {
	
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);
	private static BookService bs = new BookService();
	private static EmployeeService es = new EmployeeService();
	
	public Controller() throws ServiceException{
		doLogic();
	}
	
	private void doLogic() throws ServiceException{
		
		String ch = "y";
		do{
		LOGGER.info("Please enter your choise: \nrename book - press 1; \n"
				+ "choose employess hwo've read more than one book - 2; \n"
				+ "choose employess hwo've read less than three books - 3; ");
		
		Scanner scan = new Scanner(System.in);
		int choise = scan.nextInt();
		switch(choise){
		case 1:
			String[] names = createBrief();
			bs.renameBook(names[0], names[1]);
			break;
		case 2:
			es.selectMoreThanOne();
			break;
		case 3:
			es.selectLessThanThree();
			break;
		default:
			LOGGER.info("Wrong choise, please check!");
			break;
		}
		LOGGER.info("Please type 'y' if you want prolong, or any key to quit.");
		Scanner s = new Scanner(System.in);
		ch = s.nextLine();
		}while(ch.equals("y"));
		
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
		return briefs;
	}

}
