package com.revature.dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	
	public List<Bid> readMultiple(int[] bidIds) {
		StringBuilder ids = new StringBuilder();
		
		for(int i = 0; i < bidIds.length; i++) {
			ids.append(bidIds[i]);
			if(i < bidIds.length - 1) {
				ids.append(", ");
			}
			
		}
		String hql = "from Bid where bidId in (" + ids.toString() + ")";
		
		System.out.println(hql);
		
		Query<Bid> query = sess.createQuery(hql, Bid.class);
		List<Bid> result = query.getResultList();
		return result;
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
