package com.learning.jpa.advanced.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;


@Entity
public  class FullTimeEmployee extends Employee {
	
	
	private BigDecimal salary;

	
	
	
	public FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	public BigDecimal getHourlyWage() {
		return salary;
	}

	public void setHourlyWage(BigDecimal salary) {
		this.salary = salary;
	}
	
	

}
