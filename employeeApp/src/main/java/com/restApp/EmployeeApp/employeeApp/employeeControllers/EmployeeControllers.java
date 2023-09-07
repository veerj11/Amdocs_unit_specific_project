package com.restApp.EmployeeApp.employeeApp.employeeControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.EmployeeApp.employeeApp.Exceptions.EmployeeDoesNotExist;
import com.restApp.EmployeeApp.employeeApp.employee.Employee;
import com.restApp.EmployeeApp.employeeApp.employeeService.EmployeeService;

@RestController
public class EmployeeControllers {

	@Autowired
	EmployeeService empService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> t = empService.fetchAllEmployees();
		return new ResponseEntity<>(t,HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = Optional.of(new Employee());
		emp = empService.fetchEmployeeByID(id);
		return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		empService.insertEmployeeById(emp);
		return new ResponseEntity<>(null,HttpStatus.CREATED);
	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		
			empService.updateEmployee(emp);
			return new ResponseEntity<>(null,HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
			empService.deleteEmployee(id);
			return new ResponseEntity<>(null,HttpStatus.OK);
	}
}