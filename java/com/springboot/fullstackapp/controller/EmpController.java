package com.springboot.fullstackapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysql.cj.Session;
import com.springboot.fullstackapp.entity.Employee;
import com.springboot.fullstackapp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
    
	@GetMapping("/")
	public String home(Model m)
	{   
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
		
	}
	@GetMapping("/addemp")
   public String addEmp()
   {
	   return "addEmp";
   }
	
	@PostMapping("/register")
	public String submit(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee details added successfully...!!");
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model m)
	{  
		Employee e =service.getEmployeeId(id);
		m.addAttribute("emp", e);
		return "update";
		
	}
	
	@PostMapping("/update")
	public String updateEmployeeDetails(@ModelAttribute Employee e, HttpSession session)
	{ 
	 service.addEmp(e);
	 session.setAttribute("msg", "Employee details updated successfully...!!");
	 return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpSession session)
	{
	service.deleteEmployeeId(id);
	session.setAttribute("msg", "Employee details deleted successfully...!!");
	return "redirect:/";	
	}
}
