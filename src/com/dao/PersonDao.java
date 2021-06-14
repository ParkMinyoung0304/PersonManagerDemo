package com.dao;

import java.util.List;

import com.po.Person;

public interface PersonDao {
	
	public List<Person> findAll();
	public void addPerson(Person person);
	public void delPerson(int uid);
	public Person findById(String uid);
	public void updatePerson(Person person);
}
