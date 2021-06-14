package com.dao;

import org.springframework.stereotype.Repository;

import com.po.Login;

@Repository("loginDao")
public interface LoginDao {
	
	public Login loginCheck(Login login);
}
