package com.revature.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class UserTradeId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5884275393083855432L;

	@NotNull
	@Column(name="USERID")
	private int userId;
	
	@NotNull
	@Column(name="TRADEID")
	private int tradeId;

	public UserTradeId() {
		super();
	}

	public UserTradeId(@NotNull int userId, @NotNull int tradeId) {
		super();
		this.userId = userId;
		this.tradeId = tradeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public String toString() {
		return "UserTradeId [userId=" + userId + ", tradeId=" + tradeId + "]";
	}
}
