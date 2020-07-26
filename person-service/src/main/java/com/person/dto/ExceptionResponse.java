package com.person.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonPropertyOrder
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement(name = "response")
public class ExceptionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4705565673209123093L;

	private String code;

	private String message;

	private String desc;

	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(String code, String message, String desc) {
		super();
		this.code = code;
		this.message = message;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
