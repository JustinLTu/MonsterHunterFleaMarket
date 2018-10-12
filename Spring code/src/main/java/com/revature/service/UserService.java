package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.entities.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class UserService implements GenericService<UserAccount>{
	
	UserDao dao = new UserDao();

	@Override
	public UserAccount read(int id) {
		return dao.read(id);
	}
	
	public UserAccount read(UserAccount user) {
		return dao.read(user.getUsername(), user.getPassword());
	}

	@Override
	public void create(UserAccount t) {
		dao.create(t);
	}

	@Override
	public UserAccount update(int id, UserAccount t) {
		return dao.update(id, t);
	}

	@Override
	public void delete(UserAccount account) {
		dao.delete(account);
	}
	
	public boolean validate(UserAccount credentials) {
		return dao.read(credentials.getUsername(), credentials.getPassword()) != null;
	}
	
	public UserAccount validateUser(UserAccount credentials) {
		return dao.read(credentials.getUsername(), credentials.getPassword());
	}
}
