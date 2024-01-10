package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployeeById(Long deptId);
	void deleteEmployee(Long id);
}
