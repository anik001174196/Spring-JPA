package com.learning.jpa.advanced.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String number;
	
	// student will created passport_id
	// for mappedBy argument Passport will not create Student_id
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;


	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

}
