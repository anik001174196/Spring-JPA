package com.learning.jpa.advanced.repositories;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.advanced.entities.Passport;
import com.learning.jpa.advanced.entities.Student;

@Repository
@Transactional // if there is a change in database then this beans need to be added
public class StudentRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}
	
	public void deleteById(long id) {
		Student student =  findById(id);
		entityManager.remove(student);
	}
	
	public Student save(Student student) {
		if (student.getId() ==  null) {
			entityManager.persist(student);
		} else {
			entityManager.merge(student);
		}
		
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("VF4234");
		entityManager.persist(passport);
		Student student = new Student("Mike", passport);
		entityManager.persist(student);
	}
	
	
}
