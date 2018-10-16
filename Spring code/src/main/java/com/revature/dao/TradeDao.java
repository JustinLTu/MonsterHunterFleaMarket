package com.revature.dao;

import javax.persistence.OptimisticLockException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.jboss.logging.Logger;

import com.revature.entities.Trade;
import com.revature.util.SessionUtil;

public class TradeDao implements Dao<Trade> {

	Session sess = SessionUtil.getSession();
	
	private Logger log = Logger.getLogger(TradeDao.class);
	
	@Override
	public Trade read(int id) {
		return sess.get(Trade.class, id);
	}

	@Override
	public int create(Trade t) {
		Transaction trans = sess.beginTransaction();
		sess.save(t);
		trans.commit();
		return t.getTradeId();
	}

	@Override
	public Trade update(int id, Trade t) {
		
		Trade current = sess.get(Trade.class, id);
		if(current != null) {
			try {
				Transaction trans = sess.beginTransaction();
				current.setItemName(t.getItemName());
				current.setItemQuantity(t.getItemQuantity());
				current.setMessage(t.getMessage());
				current.setOffer(t.isOffer());
				sess.update(current);
				trans.commit();
				return current;
			} catch (OptimisticLockException e) {
				log.warn("Inside Trade.update(int, Trade) " + e.getMessage());
				sess.getTransaction().rollback();
				return null;
			}
			
		} else {
			return null;
		}
	}

	@Override
	public void delete(Trade t) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.delete(t);
			trans.commit();
		} catch (OptimisticLockException e) {
			log.warn("Inside Trade.delete(Trade) " + e.getMessage());
			sess.getTransaction().rollback();
		}
	}
}
