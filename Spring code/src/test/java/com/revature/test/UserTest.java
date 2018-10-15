package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.dao.UserDao;
import com.revature.entities.UserAccount;
import com.revature.service.UserService;

class UserTest {
	
	@Mock
	UserDao mockedDao;
	
	@InjectMocks
	UserService uService;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mockedDao = Mockito.mock(UserDao.class);
		uService = new UserService();
		uService.setDao(mockedDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUserDao() {
		UserAccount testA = new UserAccount("Hatter", "pass", 1, "MadHatter", "test@mail" );
		UserDao udao = new UserDao();
		udao.create(testA);
		
		assertEquals("test@mail", udao.read("Hatter", "pass").getEmail());
		
		UserAccount testB = new UserAccount("Hatter", "secret", 1, "Rabbit", "rabbit@gmail");
		UserAccount res = udao.update(testA.getUserid(), testB);
		assertEquals("Rabbit", udao.read("Hatter", "secret").getHunter_name());
		assertEquals("rabbit@gmail", udao.read("Hatter", "secret").getEmail());
		
		udao.delete(res);
		assertNull(udao.read(1));
	}
	
	@Test
	public void userServiceTest() {
		UserAccount acc1 = new UserAccount("blah", "p", 2, "blah2", "blah2@mail");
		UserAccount acc2 = new UserAccount("hello", "weee", 3 , "hello", "h@h");
		Mockito.when(mockedDao.create(Mockito.any())).thenReturn(1);
		Mockito.when(mockedDao.read(Mockito.anyInt())).thenReturn(acc1);
		Mockito.when(mockedDao.update(acc1.getUserid(), acc2)).thenReturn(acc2);
		uService.setDao(mockedDao);
		
		uService.create(acc1);
		
		assertEquals(acc1.getEmail(), uService.read(acc1.getUserid()).getEmail());
		assertEquals(acc1.getRank(), uService.read(acc1.getUserid()).getRank());
		assertEquals(acc1.getUsername(), uService.read(acc1.getUserid()).getUsername());
		assertEquals(acc1.getEmail(), uService.read(acc1.getUserid()).getEmail());
		
		uService.update(acc1.getUserid(), acc2);
		Mockito.when(mockedDao.read(Mockito.anyInt())).thenReturn(acc2);
		
		assertEquals(acc2.getEmail(), uService.read(acc1.getUserid()).getEmail());
		assertEquals(acc2.getRank(), uService.read(acc1.getUserid()).getRank());
		assertEquals(acc2.getUsername(), uService.read(acc1.getUserid()).getUsername());
		assertEquals(acc2.getEmail(), uService.read(acc1.getUserid()).getEmail());
		
		uService.delete(acc1);
		Mockito.when(mockedDao.read(Mockito.anyInt())).thenReturn(null);
		assertNull(uService.read(acc1.getUserid()));
	}
}
