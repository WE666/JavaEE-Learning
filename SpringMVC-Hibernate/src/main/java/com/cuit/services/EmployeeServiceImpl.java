package com.cuit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuit.dao.EmployeeDao;
import com.cuit.model.Employee;

@Service
@Transactional   

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDAO;
	
	@Override 
	@Transactional
	public void deleteEmployee(Integer employeeId){
		employeeDAO.deleteEmployee(employeeId);
	}
	@Override
	@Transactional
	public void addEmployee(Employee employee){
		employeeDAO.addEmployee(employee);	}
	
	@Override
	@Transactional
	public void update(Employee employee){
		 employeeDAO.updateEmployee(employee);
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();	}
	
	@Override 
	@Transactional
	public Employee findById(Integer employeeId){
		return employeeDAO.getEmployee(employeeId);
	}

}
