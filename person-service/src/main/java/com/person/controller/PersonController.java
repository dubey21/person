package com.person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.dto.PersonDto;
import com.person.service.PersonService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@CrossOrigin
@RequestMapping(value = "/persons")
public class PersonController {

	private PersonService service;

	public PersonController(PersonService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<PersonDto> getAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public PersonDto get(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public PersonDto save(@RequestBody PersonDto dto) {
		return service.save(dto);
	}

	@PutMapping
	public PersonDto update(@RequestBody PersonDto dto) {
		return service.update(dto);
	}

	@PutMapping(value = "/{id}/{connection_id}")
	public PersonDto connect(@PathVariable("id") Long id, @PathVariable("connection_id") Long connection_id) {
		return service.connect(id, connection_id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
