package com.learning.jpa.advanced.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// makes the calss jpa entity
@Entity
@Table(name="Course")
public class Course {
	@Id
	@GeneratedValue // jpa will generate the value
	private Long id;

	@Column(name="fullname", nullable = false)
	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	// id is auto generated , so we don't need to put id as constructor
	public Course(String name) {
		super();
		this.name = name;
	}

	// we donot need setID , as id is auto generated
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
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	

}
