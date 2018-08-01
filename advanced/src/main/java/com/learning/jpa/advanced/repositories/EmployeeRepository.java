package com.learning.jpa.advanced.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.jpa.advanced.entities.Employee;
import com.learning.jpa.advanced.entities.FullTimeEmployee;
import com.learning.jpa.advanced.entities.PartTimeEmployee;

@Repository
@Transactional 
public class EmployeeRepository {

	@Autowired
	private EntityManager entityManager;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}

	
	public List<PartTimeEmployee> retrievePartTimeAllEmployess() {
		return entityManager.createQuery("Select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveFullTimeAllEmployess() {
		return entityManager.createQuery("Select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}
