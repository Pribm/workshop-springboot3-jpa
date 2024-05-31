package com.pvrmweb.course.config;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;
import com.pvrmweb.course.entities.Category;
import com.pvrmweb.course.entities.Order;
import com.pvrmweb.course.entities.Product;
import com.pvrmweb.course.entities.User;
import com.pvrmweb.course.entities.enums.OrderStatus;
import com.pvrmweb.course.repositories.CategoryRepository;
import com.pvrmweb.course.repositories.OrderRepository;
import com.pvrmweb.course.repositories.ProductRepository;
import com.pvrmweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Faker faker = new Faker();
		
		if(userRepository.count() < 50) {
			
			for (int i = 0; i < 50; i++) {
				String name = faker.name().fullName();
				String email = name.replace(" ", "_").replace(".", "")+"@gmail.com";
				String phone = faker.phoneNumber().cellPhone();
				String password = "password";
				
				User u = userRepository.save(new User(null, name, email, phone, password));
				
				Order order = new Order(null, Instant.parse("2019-07-21T00:00:00Z"), OrderStatus.SHIPPED, u);
				this.orderRepository.save(order);
			}
		}
		
		Set<Category> categoriesList = new HashSet<>();
		
		for (int i = 0; i < 20; i++) {
			Category c = this.categoryRepository.save(new Category(null, faker.commerce().department()));
			categoriesList.add(c);
		}
		
		for (int i = 0; i < 20; i++) {
			Product product = new Product(null, faker.commerce().productName(), faker.lorem().paragraphs(1).get(0), Double.parseDouble(faker.commerce().price().replace(",", ".")), "lorem/ipsum/123");
			product.getCategories().addAll(categoriesList);
			this.productRepository.save(product);
		}
	}
}
