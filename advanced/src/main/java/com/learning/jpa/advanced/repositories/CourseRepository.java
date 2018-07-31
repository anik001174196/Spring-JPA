package com.learning.jpa.advanced.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.advanced.entities.Course;
import com.learning.jpa.advanced.entities.Review;

@Repository
@Transactional // if there is a change in database then this beans need to be added
public class CourseRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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

	
	
	public void playWithHIbernateTable() {
		Course course = findById(10001L);
		course.setName("Ami Jani na");
		entityManager.persist(course);
		
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
		course1.setName("Abcd John's Book");
		
		// entity manager gets the value from database for course 1  and 
		// course1.setName("Abcd John's Book"); will not execute
		//entityManager.refresh(course1);
		//entityManager.flush();
	}
	
	public void addReviewForCourse() {
		Course course = findById(10003L);
		logger.info("course.getReview --> {}",course.getReviews());
		
		Review review1 = new Review("5", "Great hands of stuff");
		Review review2 = new Review("5", "Liked it very much");
		
		//course.addReview(review1);
		review1.setCourse(course);
		//course.addReview(review2);
		review2.setCourse(course);
		
		entityManager.persist(review1);
		entityManager.persist(review2);
		
	}
	
	
	public void addReviewForACourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("course.getReview --> {}",course.getReviews());
		
		
		
		for(Review review: reviews) {
			review.setCourse(course);
			entityManager.persist(review);
		}
		
		
	}
}
