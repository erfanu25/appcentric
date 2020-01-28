package org.erfan.erfanu25;

import org.erfan.erfanu25.entity.CustomerEntity;
import org.erfan.erfanu25.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Erfanu25Application {

	public static void main(String[] args) {
		SpringApplication.run(Erfanu25Application.class, args);
	}

	@Bean
	public CommandLineRunner demoData(CustomerRepository customerRepository) {
		return args -> {
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setName("Erfan");
			customerEntity.setDate(new Date());
			customerEntity.setEmail("mderfan2@gmail.com");
			customerRepository.save(customerEntity);
		};
	}

}
