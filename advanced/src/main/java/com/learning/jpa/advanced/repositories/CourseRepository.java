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
		Course course1 =  new Course("Anik Saha/s Book");
		entityManager.persist(course1);
		entityManager.flush(); // all the changes upto this line will go to database,
		                       //it will not wait till the end of function
		
		// this line with executes and changes wil save into database because of the 
		// @Transactional annotaion entityManager checks the entire function and update database
		
		
		Course course2 =  new Course("Anik Saha/s Book");
		entityManager.persist(course2);
		entityManager.flush();
		entityManager.detach(course2); // after this any update to course2 will not work
		
		entityManager.clear(); // nothing will be tracked or changed in database after the line is executed
		course2.setName("John's Book");
		entityManager.flush();
		
		course1.setName("John's Book");
		entityManager.flush();
	}
}
