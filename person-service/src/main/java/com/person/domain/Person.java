package com.person.domain;

import java.io.Serializable;
import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3705890208070662649L;

	@Id
	@GeneratedValue
	private Long id;

	private String fullName;

	private String email;

	private String phoneNo;

	@Relationship(type = "KNOWS", direction = "UNDIRECTED")
	private Person relative;

	private Date createdOn = new Date();

	private Date updatedOn = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Person getRelative() {
		return relative;
	}

	public void setRelative(Person relative) {
		this.relative = relative;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
