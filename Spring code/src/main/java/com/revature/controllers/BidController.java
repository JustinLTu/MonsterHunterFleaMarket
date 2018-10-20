package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.embeddable.TradeBidsId;
import com.revature.entities.Bid;
import com.revature.entities.Trade;
import com.revature.entities.TradeBids;
import com.revature.service.BidService;
import com.revature.service.TradeService;
import com.revature.service.UserService;

@RestController
@RequestMapping("/bids")
public class BidController {
	
	@Autowired
	BidService bService;
	
	@Autowired
	TradeService tService;
	
	@Autowired
	UserService uService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes= {"application/json"}, produces={"application/json"})
	public Bid postBid(@RequestBody Bid bid, @RequestParam String tradeid, @RequestParam String userid) {
		
		bid.setUserId(Integer.parseInt(userid));
		bService.create(bid);
		
		Trade trade = tService.read(Integer.parseInt(tradeid));
		TradeBids tb = new TradeBids();
		tb.setTradeBidsId(new TradeBidsId(bid.getBidId(), trade.getTradeId()));
		bService.createTradeBids(tb);
		
		return bid;
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces={"application/json"})
	public Bid[] getAllBidsOfTrade(@RequestParam int tradeid) {
		return bService.readAllByTradeId(tradeid);
	}
}
