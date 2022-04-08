package com.mescobar.jpatest.repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mescobar.jpatest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);
	
	List<User> findByNameIs(String name);
	List<User> findByNameEquals(String name);
	
	List<User> findByNameIsNull();
	List<User> findByNameIsNotNull();
	
	List<User> findByActiveTrue();
	List<User> findByActiveFalse();
	
	List<User> findByNameStartingWith(String prefix);
	List<User> findByNameEndingWith(String suffix);
	List<User> findByNameContaining(String infix);
	
	List<User> findByNameLike(String likePattern);
	
	
	List<User> findByAgeLessThan(Integer age);
	List<User> findByAgeLessThanEqual(Integer age);
	
	List<User> findByAgeGreaterThan(Integer age);
	List<User> findByAgeGreaterThanEqual(Integer age);
	List<User> findByAgeBetween(Integer startAge, Integer endAge);
	List<User> findByAgeIn(Collection<Integer> ages);
	
	
	List<User> findByBirthDateAfter(ZonedDateTime birthDate);
	List<User> findByBirthDateBefore(ZonedDateTime birthDate);
	
	List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
	List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);
	
	
	List<User> findByNameOrderByName(String name);
	List<User> findByNameOrderByNameAsc(String name);
	
	
}
