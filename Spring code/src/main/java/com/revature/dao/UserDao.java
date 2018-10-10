package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.entities.UserAccount;
import com.revature.util.SessionUtil;

public class UserDao implements Dao<UserAccount> {
	
	Session sess = SessionUtil.getSession();
	
	@Override
	public UserAccount read(int id) {
		return sess.get(UserAccount.class, id);
	}
	
	public UserAccount read(String username, String password) {
		String hql = "select * from USER_ACCOUNTS where USERNAME = :user and PASSWORD = :pass";
		Query<UserAccount> query = sess.createQuery(hql, UserAccount.class);
		query.setParameter("user", username);
		query.setParameter("pass", password);
		List<UserAccount> result = query.getResultList();
		
		if(result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void create(UserAccount t) {
		Transaction trans = sess.beginTransaction();
		sess.save(t);
		trans.commit();
	}

	@Override
	public boolean update(int id, UserAccount t) {
		if(sess.get(UserAccount.class, id) != null) {
			Transaction trans = sess.beginTransaction();
			sess.merge(t);
			trans.commit();
			return true;
		}
		return false;
	}

	@Override
	public void delete(UserAccount t) {
		Transaction trans = sess.beginTransaction();
		sess.delete(t);
		trans.commit();
	}

}
