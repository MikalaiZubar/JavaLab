package com.epam.library.command;

import com.epam.library.exeption.ServiceException;

public interface ICommand {

	void execute() throws ServiceException;
}
