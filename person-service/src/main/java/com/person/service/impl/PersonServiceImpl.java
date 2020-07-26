package com.person.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.person.dao.PersonDao;
import com.person.domain.Person;
import com.person.dto.PersonDto;
import com.person.service.PersonService;

/**
 * 
 * @author deepakdubey
 *
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private PersonDao dao;

	public PersonServiceImpl(PersonDao dao) {
		super();
		this.dao = dao;
	}

	/**
	 * {@code Return all available records.}
	 */
	@Override
	public List<PersonDto> findAll() {
		return etm_col.apply(dao.findAll());
	}

	/**
	 * {@code Return record against given id}
	 */
	@Override
	public PersonDto findById(Long id) {
		Optional<Person> op = dao.findById(id);
		return op.isPresent() ? etm.apply(op.get()) : null;
	}

	@Override
	public PersonDto save(PersonDto dto) {
		return etm.apply(dao.save(mte.apply(dto)));
	}

	@Override
	public PersonDto update(PersonDto dto) {
		return etm.apply(dao.save(mte.apply(dto)));
	}

	@Override
	public PersonDto connect(Long id, Long connection_id) {
		Optional<Person> op = dao.findById(id);
		Optional<Person> or = dao.findById(connection_id);
		Person p = op.isPresent() ? op.get() : null;
		if (p != null) {
			p.setRelative(op.isPresent() ? or.get() : null);
			return etm.apply(dao.save(p));
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Person> op = dao.findById(id);
		if (op.isPresent())
			dao.delete(op.get());

	}

}
