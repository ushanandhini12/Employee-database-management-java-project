package com.springboot.fullstackapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fullstackapp.entity.Employee;
import com.springboot.fullstackapp.repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	
	//addEmp method is for adding new employee details
	public void addEmp(Employee e)
	{
		repo.save(e);
		
	}
	
	//getAllEmp method is for getting all the employee details
   public List<Employee> getAllEmp()
   {
	   return repo.findAll();
   }
   
   //getEmployeeId method is for getting the particular Id list to update it
   public Employee getEmployeeId(int id)
   {
	   Optional<Employee> e= repo.findById(id);
	   if(e.isPresent())
	   {
		   return e.get();
	   }
	   return null;
   }
   
   public void deleteEmployeeId(int id)
   {
	   repo.deleteById(id);
   }
}
