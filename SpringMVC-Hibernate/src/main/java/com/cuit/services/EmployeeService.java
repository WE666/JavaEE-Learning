package com.cuit.services;

import java.util.List;

import com.cuit.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
	public void update(Employee employee);
	public Employee findById(Integer employeeId);

}
