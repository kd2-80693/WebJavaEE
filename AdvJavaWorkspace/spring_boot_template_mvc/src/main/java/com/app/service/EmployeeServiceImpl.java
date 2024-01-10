package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployeeById(Long deptId) {
		return employeeDao.findByDeptId(deptId);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDao.deleteById(id);
		
	}

	
}
