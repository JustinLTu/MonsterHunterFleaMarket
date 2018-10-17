package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.dao.TradeDao;
import com.revature.entities.Trade;

@Service
public class TradeService implements GenericService<Trade> {

	private TradeDao dao;
	
	public TradeService() {
		super();
		dao = new TradeDao();
	}

	@Override
	public Trade read(int id) {
		return dao.read(id);
	}

	@Override
	public void create(Trade object) {
		dao.create(object);
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
