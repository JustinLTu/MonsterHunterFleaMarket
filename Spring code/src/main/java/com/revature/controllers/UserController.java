package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.UserAccount;
import com.revature.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET, produces= {"text/plain"})
	public String login(UserAccount attempt) {
		return "forward:/index.html";
	}
	
	@RequestMapping(value="/accounts",  method = RequestMethod.POST, consumes= {"application/json"})
	public void register(@RequestBody UserAccount user) {
		service.create(user);
	}
	
	@RequestMapping(value="/loginr", method=RequestMethod.POST, consumes= {"application/json"})
	public String loginPost(@RequestBody UserAccount user, BindingResult bindingResult, ModelMap modelMap, HttpSession sess) {
		
		//UserAccount testA = new UserAccount("test", "test", 1, "testk", "test");
		UserAccount authUser = service.validateUser(user);
		
		if(bindingResult.hasErrors()) {
			modelMap.addAttribute("errorMessage", bindingResult.getAllErrors().get(0).getDefaultMessage());
			
			return "login";
		}
		
		//System.out.println(authUser.toString());
		if(authUser != null) {
			sess.setAttribute("user", authUser);
			System.out.println("going home");
			return "home";
		}
		
		modelMap.addAttribute("errorMessage", "Username or password incorrect");
		
		return "forward:/index.html";
		
	}
}
