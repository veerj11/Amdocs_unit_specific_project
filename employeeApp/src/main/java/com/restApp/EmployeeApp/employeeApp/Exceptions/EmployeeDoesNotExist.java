package com.restApp.EmployeeApp.employeeApp.Exceptions;

public class EmployeeDoesNotExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeDoesNotExist(String str) {
		super(str);
	}

}
