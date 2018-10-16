package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.dao.TradeDao;
import com.revature.entities.Trade;
import com.revature.service.TradeService;

class TradeTest {
	
	@Mock
	private TradeDao tDao;
	
	@InjectMocks
	private TradeService tService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDaoCRUD() {
		TradeDao testDao = new TradeDao();
		Trade testTrade = new Trade(true, "clean bone", 2, "In exchange for raw hides");
		testTrade.setTradeId(testDao.create(testTrade));
		
		String readItemName = testDao.read(testTrade.getTradeId()).getItemName();
		assertEquals(testTrade.getItemName(), readItemName);
		
		Trade testTrade2 = new Trade(true, "broken bone", 4, "In exchange for raw hides");
		
		Trade resultTrade = testDao.update(testTrade.getTradeId(), testTrade2);
		
		readItemName = testDao.read(resultTrade.getTradeId()).getItemName();
		assertEquals(testTrade2.getItemName(), readItemName);
		
		testDao.delete(resultTrade);
		assertNull(testDao.read(resultTrade.getTradeId()));
	}

}
