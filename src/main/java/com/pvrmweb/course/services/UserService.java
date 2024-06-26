package com.pvrmweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvrmweb.course.entities.User;
import com.pvrmweb.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).get();
	}

	public User deleteById(Long id) {
		User user = this.findById(id);
		
		if(user != null) {
			repository.deleteById(id);
			return user;
		}
		
		throw new RuntimeException("User Not Found");
	}
}
