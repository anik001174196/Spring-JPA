package com.learning.jpa.advanced.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;


@Entity
public  class PartTimeEmployee extends Employee {
	
	
	private BigDecimal hourlyWage;

	
	
	
	public PartTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
	

}
