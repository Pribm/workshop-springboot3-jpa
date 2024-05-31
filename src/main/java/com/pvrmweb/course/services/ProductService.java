package com.pvrmweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvrmweb.course.entities.Product;
import com.pvrmweb.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product save(Product product) {
		return repository.save(product);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		return repository.findById(id).get();
	}

	public Product deleteById(Long id) {
		Product product = this.findById(id);
		
		if(product != null) {
			repository.deleteById(id);
			return product;
		}
		
		throw new RuntimeException("Product Not Found");
	}
}
