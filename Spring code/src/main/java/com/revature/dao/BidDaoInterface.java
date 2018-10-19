package com.revature.dao;

import com.revature.entities.Bid;

public interface BidDaoInterface {
	
	public int create(Bid bid);
	public Bid read(int bidId);
	public void delete(Bid bid);
}
