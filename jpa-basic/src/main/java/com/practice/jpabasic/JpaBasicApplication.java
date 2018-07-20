package com.practice.jpabasic;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.jpabasic.dao.PersonJdbcDAO;
import com.practice.jpabasic.jpaRepository.PersonJpaRepository;
import com.practice.jpabasic.models.Person;

@SpringBootApplication
public class JpaBasicApplication implements CommandLineRunner {
 
	@Autowired
    PersonJpaRepository personJpaRepository;
	
	//sfl4j
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("User Id 10001 -> {}" ,  personJpaRepository.findById(10001));
		logger.info("User Id 10002 -> {}" ,  personJpaRepository.findById(10002));
		logger.info(" Deleting 10002 ,Number of rows deleted ");
		personJpaRepository.deleteById(10002);
		logger.info("All users -> {}" ,  personJpaRepository.findAll());
		logger.info("Inserting 10004 -> {}" , 
				personJpaRepository.insert(new Person( "NoName", "Toronto", new Date())));
	    logger.info("All users -> {}" ,  personJpaRepository.findAll());
	    logger.info("Updating 10001 -> {}" , 
	    		personJpaRepository.update(new Person(10001, "Anik", "Canada", new Date())));
	    logger.info("All users -> {}" ,  personJpaRepository.findAll());
	}
}
