package com.practice.jpabasic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.jpabasic.models.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//  return how many rows are deleted
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", 
				new Object[] {id});
	}

}
