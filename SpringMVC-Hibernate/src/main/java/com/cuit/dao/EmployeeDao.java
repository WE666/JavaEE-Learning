package com.cuit.dao;

import java.util.List;

import com.cuit.model.Employee;


public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
	public void updateEmployee(Employee employee);
	public Employee getEmployee(Integer employeeid);
}