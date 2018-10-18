package com.revature.dao;

import java.util.List;

import com.revature.entities.UserTrades;

public interface UserTradesDaoInterface {
		
	public boolean create(UserTrades ut);
	public List<UserTrades> read(int userid);
	public List<UserTrades> readAll();
	public void delete(UserTrades ut);
}
