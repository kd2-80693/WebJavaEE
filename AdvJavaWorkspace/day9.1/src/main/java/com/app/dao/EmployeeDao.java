package com.app.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public interface EmployeeDao {
//add a method to insert emp details
	String addEmployeeDetails(Employee newEmp);

	// add a method to get emp details by its id
	Employee getEmpDetailsById(Integer empId);

	// get all emp details
	List<Employee> getAllEmps();

	// get all emp details by join date n salary
	List<Employee> getAllEmpByJoinDateAndSalary(LocalDate start, LocalDate end, double minSalary);

	// get last names of all emps by emp type
	List<String> getLastNamesByEmpType(EmploymentType type);

	// get selected emp details by emp type
	List<Employee> getAllEmpsByType(EmploymentType type);

//add a method to update emp salary
	String updateEmpSalary(String email, double salIncrement);

//bulk updation of salaries
	String bulkUpdateSalaryByJoinDate(LocalDate joinDate, double salIncrement);

	// add a method to delete emp details by its id
	String deleteEmpDetailsById(Integer empId);

	// add a method to store the image in db
	String storeImage(Integer empId, String imageFile) throws IOException;

	// add a method to restore the image in db
	String restoreImage(Integer empId, String newImageFile) throws IOException;

}
