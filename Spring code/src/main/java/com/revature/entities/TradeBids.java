package com.revature.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.embeddable.TradeBidsId;

@Entity
@Table(name="TRADE_BIDS")
public class TradeBids {
	
	@EmbeddedId
	protected TradeBidsId tradeBidsId;
	 
 
	/*
	@JoinColumn(name = "BIDID", nullable = false, insertable=false, updatable=false ) //, table="BIDS"
	@ManyToOne(fetch = FetchType.EAGER)
	private Bid bid;
	
	@JoinColumn(name = "TRADEID", nullable = false, insertable=false, updatable=false )//, table="TRADES"
	@ManyToOne(fetch = FetchType.EAGER)
	private Trade trade;
*/
	
	public TradeBids() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeBids(TradeBidsId tradeBidsId) {
		super();
		this.tradeBidsId = tradeBidsId;
		/*
		this.bid = bid;
		this.trade = trade;
		*/
	}

	public TradeBidsId getTradeBidsId() {
		return tradeBidsId;
	}

	public void setTradeBidsId(TradeBidsId tradeBidsId) {
		this.tradeBidsId = tradeBidsId;
	}

	@Override
	public String toString() {
		return "TradeBids [tradeBidsId=" + tradeBidsId + "]";
	}

	
	/*
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
*/
	

}
