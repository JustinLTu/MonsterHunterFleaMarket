package com.revature.dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import com.revature.entities.TradeBids;

import com.revature.util.SessionUtil;

public class TradeBidsDao implements TradeBidsInterface {

	private Session sess = SessionUtil.getSession();
	
	private Logger log = Logger.getLogger(TradeBidsDao.class);
	
	@Override
	public void create(TradeBids tradeBids) {
		try {
			Transaction trans = sess.beginTransaction();
			sess.save(tradeBids);
			trans.commit();
		} catch (RollbackException e) {
			log.warn("Inside TradeBidsDao.create(TradeBids)" + e.getMessage());
		}
		
	}

	@Override
	public List<TradeBids> readAllBids(int tradeId) {
		String hql = "from TradeBids bids where bids.tradeBidsId.tradeId = :id";
		Query<TradeBids> query = sess.createQuery(hql, TradeBids.class);
		
		
		query.setParameter("id", Integer.valueOf(tradeId));

		List<TradeBids> result = query.getResultList();
		return result;
	}

	@Override
	public TradeBids getTrade(int tBid) {
		// TODO Auto-generated method stub
		return sess.get(TradeBids.class, tBid);
	}

}
