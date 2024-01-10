package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class AddEmpDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			//create dao instance
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("Enter emp details : firstName lastName email pwd joindate type salary");
			/*
			 * firstName, String lastName, String email, String password, LocalDate
			 * joinDate, EmploymentType empType, double salary
			 */
			Employee emp = new Employee(sc.next(),sc.next(),sc.next(),
					sc.next(),LocalDate.parse(sc.next()),
					EmploymentType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println(dao.addEmployeeDetails(emp));
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
