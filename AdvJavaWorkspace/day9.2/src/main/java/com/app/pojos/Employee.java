package com.app.pojos;
/*
 * emps table 
emp_id(PK) ,first_name,last_name,email(unique),password,
join_date,
emp_type(full_time/part_time/contract...),salary
 */

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="emps")//to specify table name
public class Employee extends BaseEntity{
	@Column(name="first_name",length = 20) //col name  varchar size=20
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 30,unique = true) //adds unique constraint
	private String email;
	@Column(length = 20,nullable = false)//NOT NULL
	private String password;
//	@Transient //to skip a property from persistence
//	private String confirmPassword;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) //to store enum const names in DB col.
	@Column(name="emp_type",length = 50)
	private EmploymentType empType;
	private double salary;
	//add a property for storing image
	@Lob //=> col type : longblob
	private byte[] image;
	//asso property : Emp *--->1 Dept
	//tech terms : many , child , owning 
	@ManyToOne
	@JoinColumn(name = "dept_id" ,nullable = false )
	private Department myDept;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			EmploymentType empType, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.empType = empType;
		this.salary = salary;
	}
	


	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public EmploymentType getEmpType() {
		return empType;
	}
	public void setEmpType(EmploymentType empType) {
		this.empType = empType;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
	public Department getMyDept() {
		return myDept;
	}


	public void setMyDept(Department myDept) {
		this.myDept = myDept;
	}


	@Override
	public String toString() {
		return "Employee [empId=" +getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", empType=" + empType + ", salary=" + salary + "]";
	}
	

}
