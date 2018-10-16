package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.OptimisticLockException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.revature.entities.UserAccount;
import com.revature.util.SessionUtil;

public class UserDao implements Dao<UserAccount> {
	
	Session sess = SessionUtil.getSession();
	
	private Logger log = Logger.getLogger(UserDao.class);
	
	@Override
	public UserAccount read(int id) {
		return sess.get(UserAccount.class, id);
	}
	
	public UserAccount read(String username, String password) {
		String hql = "from UserAccount where username = :user and password = :pass ";
		
		
		Query<UserAccount> query = sess.createQuery(hql, UserAccount.class);
		
		query.setParameter("user", username);
		query.setParameter("pass", password);
		List<UserAccount> result = query.getResultList();
		//System.out.println(result.toString());
		if(result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public int create(UserAccount t) {
		Transaction trans = sess.beginTransaction();
		Serializable s = sess.save(t);
		trans.commit();
		return t.getUserid();
	}

	/**
	 * Attempts to update the UserAccount with the given id, using the
	 * provided UserAccount's information.
	 * 
	 * Returns the update UserAccount, or null if the update failed.
	 * 
	 * @return
	 */
	@Override
	public UserAccount update(int id, UserAccount t) {
		UserAccount ua = sess.get(UserAccount.class, id);
		if(ua != null) {
			try {
				Transaction trans = sess.beginTransaction();
				ua.setEmail(t.getEmail());
				ua.setHunter_name(t.getHunter_name());
				ua.setPassword(t.getPassword());
				ua.setUsername(t.getUsername());
				ua.setRank(t.getRank());
				sess.update(ua);
				trans.commit();
				return ua;
			} catch(OptimisticLockException e) {
				log.warn("Inside UserDao.update(int, UserAccount) " + e.getMessage());
				sess.getTransaction().rollback();
				return null;
			}
			
		}
		return null;
	}

	@Override
	public void delete(UserAccount t) {
		try { 
			Transaction trans = sess.beginTransaction();
			sess.delete(t);
			trans.commit();
		} catch (OptimisticLockException e) {
			log.warn("Inside UserDao.delete( UserAccount) " + e.getMessage());
			sess.getTransaction().rollback();
		}
		
	}

	public void truncateAll() {
		String hql = "truncate USER_ACCOUNTS";
				
	}
}
