package com.revature.dao;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import com.revature.entities.Bid;
import com.revature.util.SessionUtil;

public class BidDao implements BidDaoInterface {

Session sess = SessionUtil.getSession();
	
	private Logger log = Logger.getLogger(BidDao.class);
	
	@Override
	public int create(Bid bid) {
		// TODO Auto-generated method stub
		try {
			Transaction trans = sess.beginTransaction();
			Integer generatedId = (Integer) sess.save(bid);
			trans.commit();
			return generatedId.intValue();
		} catch (RollbackException e) {
			log.warn("Inside BidDao.create(Bid)" + e.getMessage());
			return -1;
		}
	}

	@Override
	public Bid read(int bidId) {
		// TODO Auto-generated method stub
		return sess.get(Bid.class, bidId);
	}

	@Override
	public void delete(Bid bid) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.delete(bid);
			trans.commit();
		} catch (RollbackException e) {
			log.warn("Inside BidDao.delete(Bid) " + e.getMessage());
			sess.getTransaction().rollback();
		}
	}
}
