package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Trade;
import com.revature.entities.UserAccount;
import com.revature.service.TradeService;
import com.revature.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService uService;
	
	@Autowired
	TradeService tService;
	
	Logger log = Logger.getLogger(UserController.class);
	
	@CrossOrigin
	@RequestMapping(value="/login", method = RequestMethod.POST, consumes= {"application/json"}, produces= {"application/json"})
	public UserAccount login(@RequestBody UserAccount attempt,  HttpSession sess, HttpServletResponse resp) {
		UserAccount authUser = uService.validateUser(attempt);

		if(authUser != null) {
			sess.setAttribute("user", authUser);
			log.info("Going Home");
				return authUser;
		} else {
			try {
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} catch (IOException e) {
				log.warn(e.getMessage() + " From UserController.login() Unauthorized Login");
			}
		}
		
		return authUser;
	}
	
	@CrossOrigin
	@RequestMapping(value="/accounts",  method = RequestMethod.POST, consumes= {"application/json"}, produces={"application/json"})
	public UserAccount register(@RequestBody UserAccount user) {
		uService.create(user);
		return  uService.read(user.getUserid());
	}
	
	@CrossOrigin
	@RequestMapping(value="/trades",  method = RequestMethod.POST, consumes= {"application/json"}, produces={"application/json"})
	public Trade postTrade(@RequestBody Trade trade, @RequestParam String userid) {
		tService.create(trade);
		System.out.println(trade.toString());
		System.out.println(userid);
		return  tService.read(trade.getTradeId());
		
	}
	
	@CrossOrigin
	@GetMapping(value="/trades")
	public List<Trade> getAllTrades() {
		
		
		return null;
	}
	
}
