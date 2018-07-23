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
public class NativeQueriesTest {

	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Test
	public void nativeQueryBasics() {
		Query query = entityManager.createNativeQuery("select * from Course", Course.class);
		List resultList = query.getResultList();
		logger.info("Select * from Course  --> {}", resultList);
		
	}
	
	@Test
	public void nativeQueryAdvancecd() {
		Query query = entityManager.createNativeQuery("select * from course where id =:id", Course.class);
		query.setParameter("id",  10002L);
		List resultList = query.getResultList();
		logger.info("Select * from Course 10002L --> {}", resultList);
		
	}
	


	

}
