package com.pvrmweb.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;
import com.pvrmweb.course.entities.User;
import com.pvrmweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		if(userRepository.count() < 50) {
			Faker faker = new Faker();
			
			for (int i = 0; i < 50; i++) {
				String name = faker.name().fullName();
				String email = name.replace(" ", "_")+"@gmail.com";
				String phone = faker.phoneNumber().cellPhone();
				String password = "password";
				
				userRepository.save(new User(null, name, email, phone, password));
			}
		}
	}
}
