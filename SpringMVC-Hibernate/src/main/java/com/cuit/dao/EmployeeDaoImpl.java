package com.cuit.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cuit.model.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee){
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> getAllEmployees(){
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
		} 
	
	@Override
	public void deleteEmployee(Integer employeeId){ 
		Employee employee=(Employee)sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if(null !=employee){
			this.sessionFactory.getCurrentSession().delete(employee);}
		}
	
	public Employee getEmployee(Integer empid){
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, empid);	
		}
	
	@Override
	public void updateEmployee(Employee employee){
		sessionFactory.getCurrentSession().update(employee);	
		}
	

}
