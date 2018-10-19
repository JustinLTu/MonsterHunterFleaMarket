package com.revature.embeddable;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TradeBidsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3221133892874894003L;
	
	@NotNull
	private int bidId;
	
	@NotNull
	private int tradeId;

	
	
	public TradeBidsId(@NotNull int bidId, @NotNull int tradeId) {
		super();
		this.bidId = bidId;
		this.tradeId = tradeId;
	}

	public TradeBidsId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
