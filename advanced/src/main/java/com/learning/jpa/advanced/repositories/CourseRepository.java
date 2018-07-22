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

}
