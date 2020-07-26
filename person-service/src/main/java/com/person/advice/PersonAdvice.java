package com.person.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.person.dto.ExceptionResponse;

@RestControllerAdvice(annotations = RestController.class)
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class PersonAdvice {

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<ExceptionResponse> handle(final IllegalArgumentException exception) {
		return new ResponseEntity<>(get(exception), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<ExceptionResponse> handle(final ConstraintViolationException exception) {
		return new ResponseEntity<>(get(exception), HttpStatus.BAD_REQUEST);
	}

	ExceptionResponse get(RuntimeException exception) {
		if (exception instanceof ConstraintViolationException)
			return new ExceptionResponse("P400", "Invalid Data", "Invalid Data");

		return new ExceptionResponse("P400", "Invalid Data", "Invalid Data");
	}
}
