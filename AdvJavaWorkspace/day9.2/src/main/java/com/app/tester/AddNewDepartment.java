package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.pojos.Department;

public class AddNewDepartment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			DepartmentDao dao = new DepartmentDaoImpl();// up casting
			System.out.println("Enter dept details : name location");
			System.out.println(dao.addNewDepartment(
					new Department(sc.next(), sc.next())));
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
