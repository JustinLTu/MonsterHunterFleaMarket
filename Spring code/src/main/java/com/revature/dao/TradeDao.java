package com.revature.dao;

import javax.persistence.RollbackException;

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
		try {
			Transaction trans = sess.beginTransaction();
			Integer generatedId = (Integer) sess.save(t);
			trans.commit();
			return generatedId.intValue();
		} catch (RollbackException e) {
			log.warn("Inside TradeDao.create(Trade)" + e.getMessage());
			return -1;
		}
	}

	@Override
	public Trade update(int id, Trade t) {
		try {
			Transaction trans = sess.beginTransaction();
			Trade current = sess.get(Trade.class, id);
			current.setItemName(t.getItemName());
			current.setItemQuantity(t.getItemQuantity());
			current.setMessage(t.getMessage());
			current.setOffer(t.isOffer());
			sess.update(current);
			trans.commit();
			return current;
		} catch (RollbackException e) {
			log.warn("Inside TradeDao.update(Trade)" + e.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Trade t) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.delete(t);
			trans.commit();
		} catch (RollbackException e) {
			log.warn("Inside Trade.delete(Trade) " + e.getMessage());
			sess.getTransaction().rollback();
		}
	}
	
	public void test() {
		
	}
}
