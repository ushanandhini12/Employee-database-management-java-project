package com.springboot.fullstackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fullstackapp.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {



}
