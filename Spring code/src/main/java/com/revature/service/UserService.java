package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.entities.UserAccount;

public class UserService implements Service<UserAccount>{
	
	UserDao dao = new UserDao();

	@Override
	public UserAccount read(int id) {
		return dao.read(id);
	}

	@Override
	public void create(UserAccount t) {
		dao.create(t);
	}

	@Override
	public boolean update(int id, UserAccount t) {
		return dao.update(id, t);
	}

	@Override
	public void delete(UserAccount account) {
		dao.delete(account);
	}
	
	public boolean validate(UserAccount credentials) {
		return dao.read(credentials.getUsername(), credentials.getPassword()) != null;
	}
}
