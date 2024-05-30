package com.pvrmweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvrmweb.course.entities.Category;
import com.pvrmweb.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category save(Category category) {
		return repository.save(category);
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		return repository.findById(id).get();
	}

	public Category deleteById(Long id) {
		Category category = this.findById(id);
		
		if(category != null) {
			repository.deleteById(id);
			return category;
		}
		
		throw new RuntimeException("Category Not Found");
	}
}
