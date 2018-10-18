package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.TradeDao;
import com.revature.dao.UserTradesDao;
import com.revature.entities.Trade;
import com.revature.entities.UserTrades;

@Service
public class TradeService implements GenericService<Trade> {

	private TradeDao dao;
	private UserTradesDao utd;
	
	public TradeService() {
		super();
		dao = new TradeDao();
		utd = new UserTradesDao();
	}

	@Override
	public Trade read(int id) {
		return dao.read(id);
	}

	@Override
	public void create(Trade object) {
		dao.create(object);
		
	}
	
	public void createUserTrades(UserTrades us) {
		dao.create(us.getTrade());
		utd.create(us);
	}
	
	public List<UserTrades> readAllUserTrades(int userid){
		return utd.read(userid);
	}
	
	public List<UserTrades> readAllTrades(){
		return utd.readAll();
	}

	@Override
	public Trade update(int id, Trade object) {
		return dao.update(id, object);
	}

	@Override
	public void delete(Trade object) {
		dao.delete(object);
	}
}
