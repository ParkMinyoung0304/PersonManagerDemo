package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonDao;
import com.po.Person;
import com.service.PersonService;

@Service("bookService")
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public List<Person> findAll() {
		// TODO 自动生成的方法存根
		return personDao.findAll();
	}

	@Override
	public void addPerson(Person person) {
		// TODO 自动生成的方法存根
		personDao.addPerson(person);
	}

	@Override
	public void delPerson(int uid) {
		// TODO 自动生成的方法存根
		personDao.delPerson(uid);
	}

	@Override
	public Person findById(String uid) {
		// TODO 自动生成的方法存根
		return personDao.findById(uid);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO 自动生成的方法存根
		personDao.updatePerson(person);
	}
	
}
	