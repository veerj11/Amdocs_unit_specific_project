package com.restApp.EmployeeApp.employeeApp.employeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.EmployeeApp.employeeApp.Exceptions.EmployeeDoesNotExist;
import com.restApp.EmployeeApp.employeeApp.Exceptions.NoEmployeesExist;
import com.restApp.EmployeeApp.employeeApp.employee.Employee;
import com.restApp.EmployeeApp.employeeApp.employeeRepository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public List<Employee> fetchAllEmployees() {
		List<Employee> empList = employeeRepo.findAll();
		if (empList.isEmpty())
			throw new NoEmployeesExist("No employees exist in the database");
		else
			return empList;
	}

	public Optional<Employee> fetchEmployeeByID(int id) {
		
		Optional<Employee> emp = Optional.of(new Employee());
		if (employeeRepo.existsById(id))
			{
				emp = employeeRepo.findById(id);
			}
		else
			throw new EmployeeDoesNotExist("Employee Not Found");
		return emp;
	}

	public void insertEmployeeById(Employee emp) {
		employeeRepo.save(emp);
	}

	public void updateEmployee(Employee emp) {
		if (employeeRepo.existsById(emp.getEmployeeId())) {
			employeeRepo.save(emp);
		} else
			throw new EmployeeDoesNotExist("Employee Not Found");
	}

	public void deleteEmployee(int id) {
		
		if (employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
		}
		else
			throw new EmployeeDoesNotExist("Employee Not Found");
	}
}