package com.revature.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.revature.entities.Trade;
import com.revature.entities.UserTrades;
import com.revature.util.SessionUtil;

public class UserTradesDao implements UserTradesDaoInterface {

	private Session sess = SessionUtil.getSession();
	
	private Logger log = Logger.getLogger(UserTradesDao.class);
	
	@Override
	public boolean create(UserTrades ut) {
		Transaction trans = sess.beginTransaction();
		Serializable s = sess.save(ut);
		trans.commit();
		if(s != null)
			return true;
		return false;
	}

	
	@Override
	public List<UserTrades> read(int userid) {
		String hql = "from UserTrades  where USERID = :uid";
		
		Query<UserTrades> query = sess.createQuery(hql, UserTrades.class);
		
		query.setParameter("uid", userid);

		List<UserTrades> result = query.getResultList();
		return result;
	}

	@Override
	public void delete(UserTrades ut) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.delete(ut);
			trans.commit();
		} catch (RollbackException e) {
			log.warn("Inside Trade.delete(Trade) " + e.getMessage());
			sess.getTransaction().rollback();
		}
		
	}


	@Override
	public List<UserTrades> readAll() {
		String hql = "from UserTrades";
		
		Query<UserTrades> query = sess.createQuery(hql, UserTrades.class);


		List<UserTrades> result = query.getResultList();
		return result;
	}
	
}
