package com.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Department> getAllDepartments() {
		String jpql = "select d from Department d";
		return factory.getCurrentSession().createQuery(jpql,Department.class).getResultList();
	}

}
