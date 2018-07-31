package com.learning.jpa.advanced;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.jpa.advanced.entities.FullTimeEmployee;
import com.learning.jpa.advanced.entities.PartTimeEmployee;
import com.learning.jpa.advanced.entities.Review;
import com.learning.jpa.advanced.repositories.CourseRepository;
import com.learning.jpa.advanced.repositories.EmployeeRepository;
import com.learning.jpa.advanced.repositories.StudentRepository;

@SpringBootApplication
public class AdvancedApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		studentRepository.saveStudentWithPassport();
		
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("5", "Great hands of stuff"));
		reviews.add(new Review("5", "Liked it very much"));
		
		courseRepository.addReviewForACourse(10002L, reviews);
		
		
		
		studentRepository.insertHardCodedStudentAndCourse();
		
		
		
		employeeRepositoryStuff();
	}
	
	
	public void employeeRepositoryStuff() {
		
		employeeRepository.insert(new PartTimeEmployee("Jack", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jill", new BigDecimal("10000")));
		
		logger.info("All Employess --> {}", employeeRepository.retrieveAllEmployess());
	}
}
