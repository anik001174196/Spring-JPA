package com.learning.jpa.advanced.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.advanced.entities.Course;

@Repository
@Transactional // if there is a change in database then this beans need to be added
public class CourseRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course =  findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() ==  null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		
		return course;
	}

	
	public void playWithEntityManager() {
		Course course =  new Course("Anik Saha/s Book");
		entityManager.persist(course);
		
		// this line with executes and changes wil save into database because of the 
		// @Transactional annotaion entityManager checks the entire function and update database
		course.setName("John's Book");
	}
}
