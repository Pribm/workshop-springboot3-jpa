package com.pvrmweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pvrmweb.course.entities.Product;
import com.pvrmweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
	    Product savedProduct = service.save(product);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> deleteById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok().body(service.deleteById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
}
