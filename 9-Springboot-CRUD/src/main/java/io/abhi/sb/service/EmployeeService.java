package io.abhi.sb.service;

import java.util.List;

import io.abhi.sb.model.Employee;
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee emp);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
