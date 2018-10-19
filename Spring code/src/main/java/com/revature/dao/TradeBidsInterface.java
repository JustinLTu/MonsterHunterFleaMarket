package com.revature.dao;

import java.util.List;

import com.revature.entities.Bid;
import com.revature.entities.Trade;
import com.revature.entities.TradeBids;

public interface TradeBidsInterface {
	public void create(TradeBids tradeBids);
	public List<TradeBids> readAllBids(int tradeId);
	public TradeBids getTrade(int bidId);
}
