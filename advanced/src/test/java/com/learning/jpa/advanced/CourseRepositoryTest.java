package com.learning.jpa.advanced;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpa.advanced.entities.Course;
import com.learning.jpa.advanced.repositories.CourseRepository;


// context gets launched , tests run and contexts destryed
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdvancedApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	@Test
	public void findByID_basicTest() {
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteByID_basicTest() {
		courseRepository.deleteById(10001L);
		assertNull(courseRepository.findById(10001L));
		
	}
	
	@Test
	@DirtiesContext// this ensures unit test actually does not delete the data
	public void saveByID_basicTest() {
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
		course.setName("New Jpa 50 starps");
		courseRepository.save(course);
		Course course1 = courseRepository.findById(10001L);
		assertEquals("New Jpa 50 starps", course1.getName());
		
		
	}

}
