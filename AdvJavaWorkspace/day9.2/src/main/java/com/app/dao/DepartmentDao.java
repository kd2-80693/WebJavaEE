package com.app.dao;

import com.app.pojos.Department;

public interface DepartmentDao {
//add a method to launch new dept
	String addNewDepartment(Department dept);
	//get dept details
	Department getDepartmentDetails(String deptName);
}
