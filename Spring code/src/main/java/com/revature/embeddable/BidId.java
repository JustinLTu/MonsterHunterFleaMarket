package com.revature.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class BidId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7098642134135090359L;

	@NotNull
	private int bidId;
	
	@NotNull
	private int tradeId;

	public BidId() {
		super();
	}

	public BidId(int bidId, int tradeId) {
		super();
		this.bidId = bidId;
		this.tradeId = tradeId;
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

	@Override
	public String toString() {
		return "BidId [bidId=" + bidId + ", tradeId=" + tradeId + "]";
	}
}
