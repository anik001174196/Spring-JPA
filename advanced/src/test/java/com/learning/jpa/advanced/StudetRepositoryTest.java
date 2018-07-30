package com.learning.jpa.advanced;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.advanced.entities.Student;
import com.learning.jpa.advanced.repositories.StudentRepository;


// context gets launched , tests run and contexts destryed
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdvancedApplication.class)
public class StudetRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Test
	@Transactional // as the class is lazy loaded so if we do not use this
	// then student.getPassport() will throw an error because data will be
	// automatically grabbed without this
	public void findStudentInfoWithPassport_basicTest() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	
	

}
