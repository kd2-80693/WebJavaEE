package com.app.dao;

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
	public String addEmployeeDetails(Employee newEmp) {
		// newEmp : transient (=> exists in java heap
//,not yet part of L1 cache,doesn't DB identity
		String mesg = "Adding emp failed!!!!";
		// 1.Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin Transaction
		Transaction tx = session.beginTransaction();
		try {
			Serializable empId = session.save(newEmp);
			// newEmp : added in L1 cache ,
			// not yet part of db : PERSISTENT
			tx.commit();// insert query , session is closed
			mesg = "Added emp details with ID= " + empId;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
//newEmp : DETACHED => from L1 cache.
		return mesg;
	}

	@Override
	public Employee getEmpDetailsById(Integer empId) {
		Employee emp = null;// emp : doesn't exist
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// Employee.class : Class<Employee> cls
			emp = session.get(Employee.class, empId);// up casting
			// in case of valid id , emp : PERSISTENT , part of L1 cache , exists in DB
//			emp = session.get(Employee.class, empId);
//			emp = session.get(Employee.class, empId);
			tx.commit();// session.flush() --> no dmls -> sessio.close()
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> emps = null;// doesn't exist
		String jpql = "select e from Employee e";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class)// Query
					.getResultList();
			// emps : List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return emps;// emps : List of DETACHED entities
	}

	@Override
	public List<Employee> getAllEmpByJoinDateAndSalary(LocalDate start, LocalDate end1, double minSalary) {
		List<Employee> emps = null;
		String jpql = "select e from Employee e where e.joinDate between :begin and :end and e.salary>:minSal";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("begin", start).setParameter("end", end1)
					.setParameter("minSal", minSalary).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return emps;// DAO rets list of detached entities to the caller
	}

	@Override
	public List<String> getLastNamesByEmpType(EmploymentType type) {
		List<String> lastNames = null;
		String jpql = "select e.lastName from Employee e where e.empType=:ty";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("ty", type).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return lastNames;
	}

	@Override
	public List<Employee> getAllEmpsByType(EmploymentType type1) {
		List<Employee> emps = null;
		String jpql = "select new com.app.pojos.Employee(firstName,lastName,salary) from Employee e where e.empType=:type";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("type", type1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return emps;
	}

	@Override
	public String updateEmpSalary(String empEmail, double salIncrement) {
		String mesg = "sal updation failed!!!!";
		String jpql = "select e from Employee e where e.email=:em";
		Employee emp = null;
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.createQuery(jpql, Employee.class).setParameter("em", empEmail).getSingleResult();
			// => emp : PERSISTENT
			emp.setSalary(emp.getSalary() + salIncrement);// modifying state of the persistent entity
			// session.evict(emp);
			// emp : detached from L1 cache
			tx.commit();// session.flush() --> auto dirty chking --> DML : update
			// --> session.close() --> L1 cache is destroyed , db cn rets to the pool
			mesg = "Updated sal of " + emp.getFirstName() + " " + emp.getLastName();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		emp.setSalary(emp.getSalary() + salIncrement);// modifying state of DETACHED entity
		return mesg;
	}

	@Override
	public String bulkUpdateSalaryByJoinDate(LocalDate joinDate, double salIncrement) {
		String mesg = "Updation failed";
		String jpql = "update Employee e set e.salary=e.salary+:incr where e.joinDate < :dt";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("incr", salIncrement).setParameter("dt", joinDate)
					.executeUpdate();
			tx.commit();
			mesg = "Updated salary of " + updateCount + " no of emps";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String deleteEmpDetailsById(Integer empId) {
		String mesg = "emp deletion failed !!!!";
		Employee emp = null;
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent emp by it's id
			emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp : persistent
				// mark the persistent emp for removal
				session.delete(emp);
				// emp : REMOVED
				mesg = "deleted emp details of " + emp.getFirstName();
			}
			tx.commit();// session.flush --> dirty chking --->
			// DML : delete , rec is deleted -->
			// session.close() --> L1 cache is destroyed
			// (entity removed from cache) : emp : TRANSIENT , cn rets to pool
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}// emp : marked for GC

	@Override
	public String storeImage(Integer empId, String imageFile) throws IOException {
		String mesg = "Image storing failed !!!!";
		// 1 . get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get emp from it's id
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp : persistent
				// validate file
				File file = new File(imageFile);// create instance of file class to store it's path
				if (file.isFile() && file.canRead()) {
					// get byte[] from image file
					emp.setImage(FileUtils.readFileToByteArray(file));
					mesg = "stored image....";
				}
			}
			tx.commit();// DML : update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String restoreImage(Integer empId, String newImageFile) throws IOException {
		String mesg="Restoring image failed !!!!!!!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get emp from it's id
			Employee emp=session.get(Employee.class, empId);
			if(emp != null)
			{
				//emp : persistent
				//4. get image from emp
				byte[] data=emp.getImage();
				if(data != null)
				{
					//=> emp exists with image
					FileUtils.writeByteArrayToFile(new File(newImageFile), data);
					mesg="restored image from db n stored in an img file";
				}
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
