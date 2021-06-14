package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Person;
import com.service.PersonService;

@Controller
@RequestMapping(value="/person")
public class PersonAction {
	
	@Autowired
	PersonService personService;
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	private List<Person> perm_filter(List<Person> lst, Person person ,int hr){

		List<Person> flst = new ArrayList<Person>(); 
		for(int i=0;i<lst.size();i++){
			if(Integer.parseInt(lst.get(i).getAccess_permission())<=Integer.parseInt(person.getAccess_permission())
					&& (lst.get(i).getClassname().equals(person.getClassname()) || hr==1)) {
	    		flst.add(lst.get(i));
	    	}
		}
		return flst;
	}

	@RequestMapping(value="/findAll.action")
	public String findPersonAll(Model model,HttpSession session){
		session.setAttribute("users",personService.findById((String) session.getAttribute("user")));
		List<Person> lst = personService.findAll();
		lst = perm_filter(lst, (Person) session.getAttribute("users") ,(int) session.getAttribute("hr_permission"));
		model.addAttribute("lstperson", lst);
		return "main";
	}
	
	@RequestMapping(value="/addOne.action")
	public String addOne(Person person,int flag){
		if(flag == 2){
			personService.addPerson(person);
			return "redirect:/person/findAll.action";
		}
		else if(flag == 1){
			return "addPerson";
		}
		return null;
	}
	
	@RequestMapping(value="/delOne.action")
	public String delOne(int sid){
		personService.delPerson(sid);
		return "redirect:/person/findAll.action";
	}
	
	@RequestMapping(value="/findById.action")
	public String findById(String sid,Model model){
		Person person = personService.findById(sid);
		model.addAttribute("person", person);
		return "update";
	}
	
	@RequestMapping(value="/updateOne.action")
	public String updateOne(Person person){
		personService.updatePerson(person);
		return "redirect:/person/findAll.action";
	}
	
	@RequestMapping(value="/delAll.action")
	public String delAll(int[] sid){
		for(int i=0;i<sid.length;i++){
			personService.delPerson(sid[i]);
		}
		return "redirect:/person/findAll.action";
	}
	
	
	@RequestMapping(value="/search.action")
	public String searchInfo(String filter, String keyword, Model model,HttpSession session){
		List<Person> lst = personService.findAll();
		List<Person> flst = new ArrayList<Person>(); 
		for(int i=0;i<lst.size();i++){
			switch(filter){
		    case "uid":
		    	if(lst.get(i).getUid().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "name":
		    	if(lst.get(i).getName().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "idcard":
		    	if(lst.get(i).getIdcard().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "phone":
		    	if(lst.get(i).getPhone().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "sex":
		    	if(lst.get(i).getSex().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "email":
		    	if(lst.get(i).getEmail().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "classname":
		    	if(lst.get(i).getClassname().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "leadername":
		    	if(lst.get(i).getLeadername().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    case "typename" :
		    	if(lst.get(i).getTypename().contains(keyword)) {
		    		flst.add(lst.get(i));
		    	}
		    	break;
		    default : //¿ÉÑ¡
		    	flst.add(lst.get(i));
		}
		}
		flst = perm_filter(flst, (Person) session.getAttribute("users"),(int) session.getAttribute("hr_permission"));
		model.addAttribute("lstperson", flst);
		return "main";
	}
	
}
