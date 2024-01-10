package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{

	List<Product> findAllByCategory(Category c);
	
}
