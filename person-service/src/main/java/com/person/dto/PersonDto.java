package com.person.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@JsonInclude(value = Include.NON_NULL)
public class PersonDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1874059659796221310L;

	@JsonProperty("id")
	private Long id;

	@NotNull
	@NotEmpty
	@JsonProperty("full_name")
	private String fullName;

	@NotNull
	@NotEmpty
	@JsonProperty("phone_no")
	private String phoneNo;

	@NotNull
	@NotEmpty
	@Email
	@JsonProperty("email")
	private String email;

	@JsonProperty("relaive")
	private PersonDto relative;

	@JsonProperty("created_on")
	private Date createdOn;

	@JsonProperty("updated_on")
	private Date updatedOn;

	public PersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDto(Long id, @NotNull @NotEmpty String fullName, @NotNull @NotEmpty String phoneNo,
			@NotNull @NotEmpty @Email String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.email = email;
	}

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PersonDto getRelative() {
		return relative;
	}

	public void setRelative(PersonDto relative) {
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
