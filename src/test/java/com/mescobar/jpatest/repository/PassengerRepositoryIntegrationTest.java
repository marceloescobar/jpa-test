package com.mescobar.jpatest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mescobar.jpatest.entity.Passenger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsNot.not;

@DataJpaTest(showSql = false)
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class PassengerRepositoryIntegrationTest {

	
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	    @Autowired
	    private PassengerRepository repository;

	    @BeforeEach 
	    public void before() {
	        entityManager.persist(Passenger.from("Jill", "Smith"));
	        entityManager.persist(Passenger.from("Eve", "Jackson"));
	        entityManager.persist(Passenger.from("Fred", "Bloggs"));
	        entityManager.persist(Passenger.from("Ricki", "Bobbie"));
	        entityManager.persist(Passenger.from("Siya", "Kolisi"));
	    }
	    
	    @Test
	    @DisplayName("Single test successful")
	    public void givenPassengers_whenMatchingIgnoreCase_thenExpectedReturned() {
	        Passenger jill = Passenger.from("Jill", "Smith");
	        Passenger eve = Passenger.from("Eve", "Jackson");
	        Passenger fred = Passenger.from("Fred", "Bloggs");
	        Passenger siya = Passenger.from("Siya", "Kolisi");
	        Passenger ricki = Passenger.from("Ricki", "Bobbie");

	        List<Passenger> passengers = repository.findByFirstNameIgnoreCase("FrED");

	        assertThat(passengers, contains(fred));
	        assertThat(passengers, not(contains(eve)));
	        assertThat(passengers, not(contains(siya)));
	        assertThat(passengers, not(contains(jill)));
	        assertThat(passengers, not(contains(ricki)));
	    }
}
