package com.person.service;

import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.person.domain.Person;
import com.person.dto.PersonDto;

public interface PersonService {

	List<PersonDto> findAll();

	PersonDto findById(Long id);

	PersonDto save(PersonDto dto);

	PersonDto update(PersonDto dto);

	PersonDto connect(Long id, Long connection_id);

	void delete(Long id);

	static Person toEntity(PersonDto dto) {
		Person entity = new Person();
		entity.setEmail(dto.getEmail());
		entity.setFullName(dto.getFullName());
		entity.setId(dto.getId());
		entity.setPhoneNo(dto.getPhoneNo());
		entity.setUpdatedOn(new Date());
		return entity;
	}

	static PersonDto toDto(Person entity) {
		PersonDto dto = new PersonDto();
		dto.setCreatedOn(entity.getCreatedOn());
		dto.setUpdatedOn(entity.getUpdatedOn());
		dto.setEmail(entity.getEmail());
		dto.setFullName(entity.getFullName());
		dto.setId(entity.getId());
		dto.setPhoneNo(entity.getPhoneNo());
		if (entity.getRelative() != null)
			dto.setRelative(new PersonDto(entity.getRelative().getId(), entity.getRelative().getFullName(),
					entity.getRelative().getPhoneNo(), entity.getRelative().getEmail()));
		return dto;
	}

	Function<PersonDto, Person> mte = (dto) -> {
		return toEntity(dto);
	};

	Function<Person, PersonDto> etm = (en) -> {
		return toDto(en);
	};

	Function<Iterable<Person>, List<PersonDto>> etm_col = (en) -> {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(en.iterator(), Spliterator.ORDERED), false)
				.map(d -> etm.apply(d)).collect(Collectors.toList());
	};

}
