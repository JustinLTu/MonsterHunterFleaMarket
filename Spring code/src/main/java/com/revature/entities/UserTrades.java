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
@Table(name = "USER_TRADES")
public class UserTrades {
	
	@Id
	@Column(name="USERTRADEID")
	@SequenceGenerator(name="USERTRADEID_SEQ", sequenceName="USERTRADEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERTRADEID_SEQ")
	private int userTradeId;
	
	/*
	 * @EmbeddedId
	protected UserTradeId userTradeId;
	 */

	@JoinColumn(name = "USERID") //, table="USER_ACCOUNTS"
	@ManyToOne(optional = false, targetEntity = UserAccount.class)
	private UserAccount userAccount;
	
	@JoinColumn(name = "TRADEID") //, table="TRADES"
	@ManyToOne(optional = false, targetEntity = Trade.class)
	private Trade trade;
	
	
	public UserTrades() {
		super();
	}


	public UserTrades(UserAccount userAccount, Trade trade) {
		super();
		this.userAccount = userAccount;
		this.trade = trade;
	}


	public UserAccount getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	public Trade getTrade() {
		return trade;
	}


	public void setTrade(Trade trade) {
		this.trade = trade;
	}


	@Override
	public String toString() {
		return "UserTrades [userAccount=" + userAccount + ", trade=" + trade + "]";
	}
		
}