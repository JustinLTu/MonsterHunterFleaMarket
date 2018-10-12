package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ACCOUNTS")
public class UserAccount {

	@Id
	@Column(name="USERID")
	@SequenceGenerator(name="USERID_SEQ", sequenceName="USERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERID_SEQ")
	private int userid;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="RANK")
	private int rank;
	
	@Column(name="HUNTER_NAME")
	private String hunter_name;
	
	@Column(name="EMAIL")
	private String email;
		
		
	
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
		
		
		
	public UserAccount(String username, String password, int rank, String hunter_name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.rank = rank;
		this.hunter_name = hunter_name;
		this.email = email;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getHunter_name() {
		return hunter_name;
	}
	public void setHunter_name(String hunter_name) {
		this.hunter_name = hunter_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserAccount [userid=" + userid + ", username=" + username + ", password=" + password + ", rank=" + rank
				+ ", hunter_name=" + hunter_name + ", email=" + email + "]";
	}
	
	
}
