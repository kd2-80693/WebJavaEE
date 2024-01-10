package com.app.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public interface EmployeeDao {
//add a method to insert emp details for a specific dept
	String addEmployeeDetails(Long deptId, Employee newEmp);

	// remove an emp from the specific dept
	String removeEmpFromDept(Long deptId, Long empId);

}
