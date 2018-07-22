package com.learning.jpa.advanced.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.jpa.advanced.entities.Course;

@Repository
public class CourseRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

}
