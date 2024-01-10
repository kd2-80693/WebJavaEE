package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.exception.ResourceNotFind;
import com.app.repositories.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new ResourceNotFind("not found with id = " + id));
	}

	@Override
	public List<Product> findAllByCategory(Category c) {
		
		return productRepository.findAllByCategory(c);
	}

	@Override
	public Product update(Product p) {
		return productRepository.save(p);
	}

	@Override
	public String delete(Product p) {
		productRepository.delete(p);
		return "Deleted";
	}

}
