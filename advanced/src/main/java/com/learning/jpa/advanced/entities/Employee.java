package com.learning.jpa.advanced.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {
	@Id
	@GeneratedValue // jpa will generate the value
	private Long id;

	@Column(name = "fullname", nullable = false)
	private String name;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
