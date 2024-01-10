package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
	@Column(name="name",length = 30)
	private String deptName;
	@Column(length = 20)
	private String location;
	// Association prop : Dept 1---->* Emp
	//tech terms : one , parent , non owning(inverse)
	@OneToMany(mappedBy ="myDept",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	//propagates ALL (save/update/delete) operations from src entity --> target entity
	private List<Employee> employees = new ArrayList<>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String deptName, String location) {
		super();
		this.deptName = deptName;
		this.location = location;
	}

	// all getters n setters
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	//As per Gavin King's suggestion , in a bi dir asso -->
	//add helper methods to add / remove emp to the dept(bi dir)
	public void addEmployee(Employee emp)
	{
		employees.add(emp);//parent ---> child
		emp.setMyDept(this);//child --> parent
	}
	public void removeEmployee(Employee emp)
	{
		employees.remove(emp);//parent --X-> child
		emp.setMyDept(null);//child ---X--> parent
	}

	// NEVER add asso properties in toString , to avoid recursion
	@Override
	public String toString() {
		return "Department " + getId() + " [deptName=" + deptName + ", location=" + location + "]";
	}
}
