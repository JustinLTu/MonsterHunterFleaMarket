package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.dao.BidDao;
import com.revature.dao.TradeBidsDao;
import com.revature.entities.Bid;
import com.revature.entities.TradeBids;

@Service
public class BidService implements GenericService<Bid> {

	BidDao bDao;
	TradeBidsDao tbDao;
	
	
	
	public BidService() {
		super();
		// TODO Auto-generated constructor stub
		bDao = new BidDao();
		tbDao = new TradeBidsDao();
		
	}

	@Override
	public Bid read(int id) {
		// TODO Auto-generated method stub
		return bDao.read(id);
	}

	@Override
	public void create(Bid object) {
		// TODO Auto-generated method stub
		bDao.create(object);
		
	}
	
	public void createTradeBids(TradeBids tb) {
		bDao.create(tb.getBid());
		tbDao.create(tb);
	}

	@Override
	public Bid update(int id, Bid object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Bid object) {
		// TODO Auto-generated method stub
		
	}

}
