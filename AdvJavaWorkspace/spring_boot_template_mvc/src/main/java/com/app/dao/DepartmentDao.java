package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
	List<Department> findAll();
}
