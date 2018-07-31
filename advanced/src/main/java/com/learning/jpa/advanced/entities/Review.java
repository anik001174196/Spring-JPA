package com.learning.jpa.advanced.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String description;
	
	@Column
	private String ratings;
	
	@ManyToOne
	private Course course;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String description) {
		super();
		this.description = description;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public Review(String description, String ratings) {
		super();
		this.description = description;
		this.ratings = ratings;
	}

	public Review(long id, String description, String ratings) {
		super();
		this.id = id;
		this.description = description;
		this.ratings = ratings;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", ratings=" + ratings + "]";
	}

}
