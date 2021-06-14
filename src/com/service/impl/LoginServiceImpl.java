package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.po.Login;
import com.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="loginDao")
	LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public Login loginCheck(Login login) {
		// TODO Auto-generated method stub
		return loginDao.loginCheck(login);
	}

}
