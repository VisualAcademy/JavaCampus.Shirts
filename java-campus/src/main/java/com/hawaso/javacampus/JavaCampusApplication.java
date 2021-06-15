package com.hawaso.javacampus;

import com.hawaso.javacampus.models.Shirt;
import com.hawaso.javacampus.repositories.ShirtRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaCampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCampusApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(JavaCampusApplication.class);

	@Bean
	public CommandLineRunner makeDefaultShirts(ShirtRepository repository) {
	  return (args) -> {
		// save a few shirts
		repository.save(new Shirt("JavaCampus"));
		repository.save(new Shirt("VisualAcademy"));
		repository.save(new Shirt("DevLec"));
		repository.save(new Shirt("Hawaso"));
  
		// fetch all shirts
		log.info("Shirts found with findAll():");
		log.info("-------------------------------");
		for (Shirt shirt : repository.findAll()) {
		  log.info(shirt.toString());
		}
		log.info("");
	  };
	}
}
