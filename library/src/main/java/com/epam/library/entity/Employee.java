package com.epam.library.entity;

import java.sql.Date;

public class Employee {
	
	private int employeeId;
	private String name;
	private Date dateOfBirth;
	private String email;
	
	
	public Employee(int employeeId, String name, Date dateOfBirth, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
