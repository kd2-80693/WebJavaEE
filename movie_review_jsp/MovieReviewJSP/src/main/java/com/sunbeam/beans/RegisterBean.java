package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoClass;
import com.sunbeam.pojos.User;

public class RegisterBean {
	int id;
	String firstName;
	String lastName;
	String email;
	String mobile;
	String birth;
	String password;
	boolean status;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public RegisterBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void registerUser()
	{
		try(UserDao u = new UserDaoClass())
		{
			Date dt = Date.valueOf(birth);
			User user = new User(id,firstName,lastName,email,mobile,dt,password);
			int cnt = u.save(user);
			if(cnt == 1)
				status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
