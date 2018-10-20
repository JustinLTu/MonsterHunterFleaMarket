package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BIDS")
public class Bid {

	@Id
	@Column(name="BIDID")
	@SequenceGenerator(name="BIDID_SEQ", sequenceName="BIDID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BIDID_SEQ")
	private int bidId;
	
	
	@JoinColumn(name="USERID")
	private int userId;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_QUANTITY")
	private int itemQuantity;

	public Bid() {
		super();
	}
	
	public Bid(int bidId, int userId, String itemName, int itemQuantity) {
		super();
		this.bidId = bidId;
		this.userId = userId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}


	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Bid [bidId=" + bidId + ", userId=" + userId + ", itemName=" + itemName + ", itemQuantity="
				+ itemQuantity + "]";
	}

}
