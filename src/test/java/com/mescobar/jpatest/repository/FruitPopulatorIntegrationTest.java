package com.mescobar.jpatest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mescobar.jpatest.entity.Fruit;


@SpringBootTest
public class FruitPopulatorIntegrationTest {

	   @Autowired
	    private FruitRepository fruitRepository;

	    @Test
	    public void givenFruitJsonPopulatorThenShouldInsertRecordOnStart() {

	        List<Fruit> fruits = fruitRepository.findAll();
	        //assertEquals("record count is not matching", 2, fruits.size());

	        fruits.forEach(fruit -> {
	            if (1 == fruit.getId()) {
	                assertEquals("apple", fruit.getName());
	                assertEquals("red", fruit.getColor());
	            } else if (2 == fruit.getId()) {
	                assertEquals("guava", fruit.getName());
	                assertEquals("green", fruit.getColor());
	            }
	        });
	    }
}
