package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.revature.embeddable.BidId;

@Entity
@Table(name="BIDS")
public class Bid {

	@EmbeddedId
	private BidId bidId;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_QUANTITY")
	private int itemQuantity;

	public Bid() {
		super();
	}

	public Bid(String itemName, int itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}

	
	public BidId getBidId() {
		return bidId;
	}

	public void setBidId(BidId bidId) {
		this.bidId = bidId;
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

	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + "]";
	}
}
