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
		// TODO �Զ����ɵķ������
		return personDao.findAll();
	}

	@Override
	public void addPerson(Person person) {
		// TODO �Զ����ɵķ������
		personDao.addPerson(person);
	}

	@Override
	public void delPerson(int uid) {
		// TODO �Զ����ɵķ������
		personDao.delPerson(uid);
	}

	@Override
	public Person findById(String uid) {
		// TODO �Զ����ɵķ������
		return personDao.findById(uid);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO �Զ����ɵķ������
		personDao.updatePerson(person);
	}
	
}
	