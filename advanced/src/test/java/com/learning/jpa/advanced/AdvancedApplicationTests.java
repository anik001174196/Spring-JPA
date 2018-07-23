package com.learning.jpa.advanced;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learning.jpa.advanced.entities.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdvancedApplicationTests {

	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Test
	public void jpqlBasics() {
		Query query = entityManager.createNamedQuery("get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select c from course c --> {}", resultList);
		
	}
	
	@Test
	public void jpql_Typed() {
		 String qlString = "get_all_courses";
		TypedQuery<Course> createQuery = entityManager.createNamedQuery(qlString, Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info("Select c from course c --> {}", resultList);
		
	}
	
	@Test
	public void jpql_where() {
		String qlString = "get_50_courses";
		TypedQuery<Course> createQuery = entityManager.createNamedQuery(qlString, Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info("Select c from course c --> {}", resultList);
		
	}


	

}
