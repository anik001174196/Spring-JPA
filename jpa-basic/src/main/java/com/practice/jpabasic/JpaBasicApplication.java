package com.practice.jpabasic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.jpabasic.dao.PersonJdbcDAO;

@SpringBootApplication
public class JpaBasicApplication implements CommandLineRunner {
 
	@Autowired
    PersonJdbcDAO personJdbcDao;
	
	//sfl4j
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users -> {}" ,  personJdbcDao.findAll());
		logger.info("User Id 10002 -> {}" ,  personJdbcDao.findById(10002));
	//	personJdbcDao.findAll();
	}
}
