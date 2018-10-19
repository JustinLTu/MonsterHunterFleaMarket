package com.revature.test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.dao.BidDao;
import com.revature.dao.TradeBidsDao;
import com.revature.entities.Bid;
import com.revature.entities.TradeBids;
import com.revature.entities.UserAccount;

class BidTest {

	BidDao bDao = new BidDao();
	TradeBidsDao tbDao = new TradeBidsDao();
	
	Bid bidTest;
	TradeBids tradeBidTest;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBidDaoCreateAndRead() {
		bidTest.setBidId(bDao.create(bidTest));
		Assert.assertEquals("Check that BidDao can get just added Bid", 
				bidTest.getItemName(), bDao.read(bidTest.getBidId()).getItemName());
		bDao.delete(bidTest);
		Assert.assertNull(bDao.read(bidTest.getBidId()));
	}
}
