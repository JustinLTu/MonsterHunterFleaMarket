package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.jboss.logging.LoggingClass;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	Logger log = Logger.getLogger(UserController.class);
	
	@CrossOrigin
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes= {"application/json"}, produces= {"application/json"})
	public UserAccount login(@RequestBody UserAccount attempt,  HttpSession sess, HttpServletResponse resp) {
		UserAccount authUser = service.validateUser(attempt);
		
		if(authUser != null) {
			sess.setAttribute("user", authUser);
			log.info("Going Home");
				//resp.sendRedirect("home");
				//resp.setStatus(HttpServletResponse.);
				return authUser;

			//return "home";
			//return "{\"name\": \"red\"}";
		} else {
			try {
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} catch (IOException e) {
				log.warn(e.getMessage() + " From UserController.login() Unauthorized Login");
			}
		}
		
		//return "forward:/index.html";
		return authUser;
	}
	
	@CrossOrigin
	@RequestMapping(value="/accounts",  method = RequestMethod.POST, consumes= {"application/json"}, produces={"application/json"})
	public UserAccount register(@RequestBody UserAccount user) {
		service.create(user);
		return  service.read(user.getUserid());
	}
	
	
}
