package com.restApp.EmployeeApp.employeeApp.Exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeDoesNotExist.class)
	public ResponseEntity<String> noEmployeeHandler(EmployeeDoesNotExist ex)
	{
		ResponseEntity<String> r = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return r;
	}
	
	@ExceptionHandler(NoEmployeesExist.class)
	public ResponseEntity<String> emptyEmployeeHandler(NoEmployeesExist ex)
	{
		ResponseEntity<String> r = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return r;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> WrongFieldHandler(MethodArgumentNotValidException ex)
	{
		List<FieldError> f= ex.getFieldErrors();
		Map<String,String> errorMp=new LinkedHashMap<>();
		for(FieldError i:f)
		{
			errorMp.put(i.getField(),i.getDefaultMessage());
		}
		ResponseEntity<Map<String,String>> r=new ResponseEntity<>(errorMp, HttpStatus.BAD_REQUEST);
		return r;
	}

}
