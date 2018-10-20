package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.BidDao;
import com.revature.dao.TradeBidsDao;
import com.revature.entities.Bid;
import com.revature.entities.Trade;
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
	public Bid read(int bidId) {
		// TODO Auto-generated method stub
		return bDao.read(bidId);
	}
	
	public Bid[] readAllByTradeId(int tradeId) {
		List<TradeBids> tradeBidsList = tbDao.readAllBids(tradeId);
		if(tradeBidsList.isEmpty()) {
			return new Bid[0];
		}
		int [] releventBidIds = new int[tradeBidsList.size()];
		
		for(int i = 0; i < tradeBidsList.size(); i++) {
			releventBidIds[i] = tradeBidsList.get(i).getTradeBidsId().getBidId();
		}
		
		List<Bid> allBids = bDao.readMultiple(releventBidIds);
		Bid[] arr = new Bid[allBids.size()];
		arr = allBids.toArray(arr);
		return arr;
	}

	@Override
	public void create(Bid object) {
		// TODO Auto-generated method stub
		bDao.create(object);
		
	}
	
	public void createTradeBids(TradeBids tb) {
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
