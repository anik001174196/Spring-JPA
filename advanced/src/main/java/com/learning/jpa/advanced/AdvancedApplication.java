package com.learning.jpa.advanced;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.jpa.advanced.entities.Course;
import com.learning.jpa.advanced.entities.FullTimeEmployee;
import com.learning.jpa.advanced.entities.PartTimeEmployee;
import com.learning.jpa.advanced.entities.Review;
import com.learning.jpa.advanced.entities.Student;
import com.learning.jpa.advanced.repositories.CourseRepository;
import com.learning.jpa.advanced.repositories.EmployeeRepository;
import com.learning.jpa.advanced.repositories.StudentRepository;

@SpringBootApplication
public class AdvancedApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EntityManager em;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//	jpql_coursesWithoutStudens();
		//jpql_coursesWith_Atleast2Studens();
		//jpql_coursesOrderByStudens();
		//jpql_studentWithPassportAtACertainPattern();
		//addReviewForACourse();
	//	insertHardCodedStudentAndCourse();
	//	employeeRepositoryStuff();
		join();
	}
	
	
	// JOIN ==> "Select c, s from Course  c JOIN c.students s"
	//LEFT JOIN =>  "Select c, s from Course  c LEFT JOIN c.students s"
	//CROSS JOIN =>  "Select c, s from Course c, Students s"

	public void join() {
		Query query = em.createQuery("Select c, s from Course  c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("result -> {}", resultList);
		
		for(Object[] result: resultList) {
			logger.info("Course {} , student {}", result[0], result[1]);
		}
	}
	
	
	public void jpql_studentWithPassportAtACertainPattern () {
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%123%'", Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("result -> {}", resultList);
	}
	
	
	public void jpql_coursesWith_Atleast2Studens () {
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("result -> {}", resultList);
	}
	
	public void jpql_coursesOrderByStudens () {
		TypedQuery<Course> query = em.createQuery("select c from Course c order by  size(c.students) desc", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("result -> {}", resultList);
	}
	
	
	public void jpql_coursesWithoutStudens() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("result -> {}", resultList);
	}
	
	

	public void addReviewForACourse() {
		studentRepository.saveStudentWithPassport();

		List<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review("5", "Great hands of stuff"));
		reviews.add(new Review("5", "Liked it very much"));

		courseRepository.addReviewForACourse(10002L, reviews);
	}

	public void insertHardCodedStudentAndCourse() {
		studentRepository.insertHardCodedStudentAndCourse();
	}

	public void employeeRepositoryStuff() {

		employeeRepository.insert(new PartTimeEmployee("Jack", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jill", new BigDecimal("10000")));

		logger.info("All Full Time Employess --> {}", employeeRepository.retrieveFullTimeAllEmployess());
		logger.info("All Part Time Employess --> {}", employeeRepository.retrievePartTimeAllEmployess());
	}
}
