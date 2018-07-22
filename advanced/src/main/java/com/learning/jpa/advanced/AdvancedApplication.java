package com.learning.jpa.advanced;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.jpa.advanced.entities.Course;
import com.learning.jpa.advanced.repositories.CourseRepository;

@SpringBootApplication
public class AdvancedApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		courseRepository.save(new Course(10002L, "Anik Saha John"));
	//	courseRepository.deleteById(10001L);
	}
}
