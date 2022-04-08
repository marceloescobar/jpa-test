package com.mescobar.jpatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mescobar.jpatest.entity.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

}
