package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoClass;
import com.sunbeam.pojos.User;

public class LoginBean {
	String email;
	String password;
	boolean status;
	
	public LoginBean() {
		
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void authenticate()
	{
		try(UserDao user = new UserDaoClass())
		{
			User u = user.findByEmail(email);
			if(u!=null && u.getPassword().equals(password)) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
