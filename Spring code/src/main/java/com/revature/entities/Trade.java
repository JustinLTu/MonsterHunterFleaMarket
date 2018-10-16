package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRADES")
public class Trade {
	
	@Id
	@Column(name="TRADEID")
	@SequenceGenerator(name="TRADEID_SEQ", sequenceName="TRADEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRADEID_SEQ")
	private int tradeId;
	
	@Column(name="IS_OFFER")
	private boolean isOffer;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_QUANTITY")
	private int itemQuantity;
	
	@Column(name="MESSAGE")
	private String message;

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trade(boolean isOffer, String itemName, int itemQuantity, String message) {
		super();
		this.isOffer = isOffer;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.message = message;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public boolean isOffer() {
		return isOffer;
	}

	public void setOffer(boolean isOffer) {
		this.isOffer = isOffer;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Trades [tradeId=" + tradeId + ", isOffer=" + isOffer + ", itemName=" + itemName + ", itemQuantity="
				+ itemQuantity + ", message=" + message + "]";
	}
}
