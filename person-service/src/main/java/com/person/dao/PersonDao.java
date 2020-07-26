package com.person.dao;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.person.domain.Person;

@Repository
public interface PersonDao extends Neo4jRepository<Person, Long> {

	Optional<Person> findById(@Param("id") Long id);

}
