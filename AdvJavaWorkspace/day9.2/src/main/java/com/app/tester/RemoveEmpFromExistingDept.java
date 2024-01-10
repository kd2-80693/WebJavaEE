package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class RemoveEmpFromExistingDept {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter dept id n emp id");
			System.out.println(dao.removeEmpFromDept(sc.nextLong(), sc.nextLong()));
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
