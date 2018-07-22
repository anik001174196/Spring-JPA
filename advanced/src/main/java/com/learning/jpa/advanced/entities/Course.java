package com.learning.jpa.advanced.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// makes the calss jpa entity
@Entity
public class Course {
	@Id
	@GeneratedValue // jpa will generate the value
	private long id;

	private String name;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	// id is auto generated , so we don't need to put id as constructor
	public Course(String name) {
		super();
		this.name = name;
	}

	// we donot need setID , as id is auto generated
	public long getId() {
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
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	

}
