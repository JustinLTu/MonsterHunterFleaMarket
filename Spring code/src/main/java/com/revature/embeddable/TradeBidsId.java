package com.revature.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class TradeBidsId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3221133892874894003L;
	
	@NotNull
	@Column(name="BIDID")
	private int bidId;
	
	@NotNull
	@Column(name="TRADEID")
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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.bidId;
		result = prime * result + this.tradeId;
		return result;
	}

	@Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
       TradeBidsId other = (TradeBidsId) obj;
       if(other.getBidId() != this.bidId) {
    	   return false;
       }
       
       if (other.getTradeId() != this.tradeId) {
    	   return false;
       }
        return true;
    }

	
}
