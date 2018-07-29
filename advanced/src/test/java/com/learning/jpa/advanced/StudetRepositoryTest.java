package com.learning.jpa.advanced;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	public void findStudentInfoWithPassport_basicTest() {
		Student student = studentRepository.findById(20001);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	
	

}
