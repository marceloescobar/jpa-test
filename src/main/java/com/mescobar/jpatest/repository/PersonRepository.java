package com.mescobar.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mescobar.jpatest.entity.Person;
import com.mescobar.jpatest.entity.projection.PersonDto;
import com.mescobar.jpatest.entity.projection.PersonView;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	PersonView findByLastName(String lastName);
	
	PersonDto findByFirstName(String firstName);
	
	<T> T findByLastName(String lastName, Class<T> type);
}
