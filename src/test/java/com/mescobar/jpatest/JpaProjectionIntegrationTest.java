package com.mescobar.jpatest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mescobar.jpatest.entity.Person;
import com.mescobar.jpatest.entity.projection.AddressView;
import com.mescobar.jpatest.entity.projection.PersonDto;
import com.mescobar.jpatest.entity.projection.PersonView;
import com.mescobar.jpatest.repository.AddressRepository;
import com.mescobar.jpatest.repository.PersonRepository;


@DataJpaTest
@ExtendWith(SpringExtension.class)
@Sql(scripts = "/projection-insert-data.sql")
@Sql(scripts = "/projection-clean-up-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class JpaProjectionIntegrationTest {

	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {
	    AddressView addressView = addressRepository.getAddressByState("CA").get(0);
	    assertThat(addressView.getZipCode()).isEqualTo("90001");
	    
	    PersonView personView = addressView.getPerson();
	    assertThat(personView.getFirstName()).isEqualTo("John");
	    assertThat(personView.getLastName()).isEqualTo("Doe");
	    
	 
	    // ...
	}
	
	@Test 
	public void whenUsingOpenProjections_thenViewWithRequiredPropertiesIsReturned() {
	    PersonView personView = personRepository.findByLastName("Doe");
	 
	    assertThat(personView.getFullName()).isEqualTo("John Doe");
	}
	
	@Test
	public void whenUsingClassBasedProjections_thenDtoWithRequiredPropertiesIsReturned() {
	    PersonDto personDto = personRepository.findByFirstName("John");
	 
	    assertThat(personDto.getFirstName()).isEqualTo("John");
	    assertThat(personDto.getLastName()).isEqualTo("Doe");
	}
	
	@Test
	public void whenUsingDynamicProjections_thenObjectWithRequiredPropertiesIsReturned() {
	    Person person = personRepository.findByLastName("Doe", Person.class);
	    PersonView personView = personRepository.findByLastName("Doe", PersonView.class);
	    PersonDto personDto = personRepository.findByLastName("Doe", PersonDto.class);

	    assertThat(person.getFirstName()).isEqualTo("John");
	    assertThat(personView.getFirstName()).isEqualTo("John");
	    assertThat(personDto.getFirstName()).isEqualTo("John");
	}
}
