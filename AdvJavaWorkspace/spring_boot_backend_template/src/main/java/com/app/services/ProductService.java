package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductService {
	List<Product> findAll();
	Product save(Product p);
	Product findById(Long id);
	List<Product> findAllByCategory(Category c);
	Product update(Product p);
	String delete(Product p);
}
