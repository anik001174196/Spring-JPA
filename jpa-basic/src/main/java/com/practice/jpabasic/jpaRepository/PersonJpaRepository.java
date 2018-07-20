package com.practice.jpabasic.jpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practice.jpabasic.models.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entity;
	
	
	public Person findById(int id) {
		return entity.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entity.merge(person);
	}
		
	public Person insert(Person person) {
		return entity.merge(person);
	}
}
