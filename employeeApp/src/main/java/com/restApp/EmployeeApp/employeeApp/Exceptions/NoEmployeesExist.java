package com.restApp.EmployeeApp.employeeApp.Exceptions;

public class NoEmployeesExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoEmployeesExist(String str) {
		super(str);
	}
}
