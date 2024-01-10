package com.app.dao;

import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployeeDetails(Long deptId, Employee newEmp) {

		String mesg = "Adding emp failed!!!!";
		// 1.Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin Transaction
		Transaction tx = session.beginTransaction();
		try {
			// get dept from it's id
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				// dept : PERSISTENT
				// call helper method establish bi dir asso between the entities
				dept.addEmployee(newEmp);
				// session.persist(newEmp);
				mesg = "Added new emp   in dept " + dept.getDeptName();
			}
			tx.commit();// insert query , session is closed

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
//newEmp : DETACHED => from L1 cache.
		return mesg;
	}

	@Override
	public String removeEmpFromDept(Long deptId, Long empId) {
		String mesg="Deleting emp details failed!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			//get dept from it's id
			Department dept=session.get(Department.class, deptId);
			//get emp from it's id
			Employee emp=session.get(Employee.class, empId);
			if(dept != null && emp != null)
			{
				dept.removeEmployee(emp);
				mesg="Deleted emp details from dept";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

}
