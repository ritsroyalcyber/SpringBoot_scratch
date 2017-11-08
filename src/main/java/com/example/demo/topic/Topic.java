package com.example.demo.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	
	@Id
	private String name;
	private String description;

	public Topic(String name, String description) {
		super();
	this.name= name;
	this.description = description;
	}
	public Topic() {}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
