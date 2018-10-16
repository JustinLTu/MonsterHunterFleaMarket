package com.revature.dao;

<<<<<<< HEAD
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
=======
import javax.persistence.OptimisticLockException;

import org.hibernate.Session;
import org.hibernate.Transaction;

>>>>>>> 739943b139bc016732f7d8ed72fbf3182384d75d
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
<<<<<<< HEAD
		try {
			Transaction trans = sess.beginTransaction();
			Integer generatedId = (Integer) sess.save(t);
			trans.commit();
			return generatedId.intValue();
		} catch (RollbackException e) {
			log.warn("Inside TradeDao.create(Trade)" + e.getMessage());
			return -1;
		}
=======
		Transaction trans = sess.beginTransaction();
		sess.save(t);
		trans.commit();
		return t.getTradeId();
>>>>>>> 739943b139bc016732f7d8ed72fbf3182384d75d
	}

	@Override
	public Trade update(int id, Trade t) {
<<<<<<< HEAD
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
=======
		
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
>>>>>>> 739943b139bc016732f7d8ed72fbf3182384d75d
			return null;
		}
	}

	@Override
	public void delete(Trade t) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.delete(t);
			trans.commit();
<<<<<<< HEAD
		} catch (RollbackException e) {
			
=======
		} catch (OptimisticLockException e) {
			log.warn("Inside Trade.delete(Trade) " + e.getMessage());
			sess.getTransaction().rollback();
>>>>>>> 739943b139bc016732f7d8ed72fbf3182384d75d
		}
	}
}
