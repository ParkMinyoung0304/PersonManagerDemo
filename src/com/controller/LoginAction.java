package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Login;
import com.po.Person;
import com.service.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginAction {
	
	
	
	@Resource(name="loginService")
	LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@RequestMapping(value="/loginCheck.action")
	public String loginCheck(Login login,HttpSession session){
		Login loginsx = loginService.loginCheck(login);
		if(loginsx != null){
			session.setAttribute("user", loginsx.getUsername());
			session.setAttribute("hr_permission", loginsx.getHr_permission());
			return "redirect:/person/findAll.action";
		}
		return "login";
	}
	
	
	@RequestMapping(value="/login.action")
	public String main(){
		return "login";
	}
	
}
