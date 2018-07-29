package com.learning.jpa.advanced.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String number;

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

	@Override
	public String toString() {
		return "Passport [number=" + number + "]";
	}

}
