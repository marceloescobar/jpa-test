package com.mescobar.jpatest.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity
public class User {

	@Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    private Integer age;
    private ZonedDateTime birthDate;
    private Boolean active;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public ZonedDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(ZonedDateTime birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
    
    
}
