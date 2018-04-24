package com.cuit.controller;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cuit.model.Employee;
import com.cuit.services.EmployeeService;

@Controller
public class EmployeeController {	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee",listEmployee);
		model.setViewName("home");
		return model;
	}
	@RequestMapping(value ="/add")
	public String add(){
		return "add";	
	}

	@RequestMapping(value = "/addEmployee")
	public String saveEmployee(Employee employee,String name,String email,String address,String telephone){
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setTelephone(telephone);
		employeeService.addEmployee(employee);	
		return ("redirect:/");
	}
	

	@RequestMapping(value = "/doupdate")
	public ModelAndView doupdate(@RequestParam(value = "id") Integer id, ModelAndView model) {
		Employee employee=employeeService.findById(id);
		model.addObject("employee",employee);
		model.setViewName("edit");
		return model;
	}
	
	@RequestMapping(value = "/update")
	public String update(Employee employee,String name,String email,String address,String telephone,Integer id){
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setTelephone(telephone);
		employeeService.update(employee);	
		return ("redirect:/");
	}
	
	@RequestMapping(value = "/deleteEmployee",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request){
		int employeeId= Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}
	
}
