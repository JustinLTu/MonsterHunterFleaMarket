package com.revature.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.embeddable.TradeBidsId;

@Entity
@Table(name="TRADE_BIDS")
public class TradeBids {
	@EmbeddedId
	private TradeBidsId tradeBidsId;
	 
 
	@JoinColumn(name = "BIDID") //, table="BIDS"
	@ManyToOne(optional = false, targetEntity = UserAccount.class)
	private Bid bid;
	
	@JoinColumn(name = "TRADEID")//, table="TRADES"
	@ManyToOne(optional = false, targetEntity = Trade.class)
	private Trade trade;

	
	
	public TradeBids() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeBids(TradeBidsId tradeBidsId, Bid bid, Trade trade) {
		super();
		this.tradeBidsId = tradeBidsId;
		this.bid = bid;
		this.trade = trade;
	}

	public TradeBidsId getTradeBidsId() {
		return tradeBidsId;
	}

	public void setTradeBidsId(TradeBidsId tradeBidsId) {
		this.tradeBidsId = tradeBidsId;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@Override
	public String toString() {
		return "TradeBids [tradeBidsId=" + tradeBidsId + ", bid=" + bid + ", trade=" + trade + "]";
	}

}
