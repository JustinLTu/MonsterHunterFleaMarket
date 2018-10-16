package com.revature.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.dao.UserDao;
import com.revature.entities.UserAccount;

class UserDaoTest {
	/*
	@Mock
	UserDao udao;
	
	@Mock
	UserAccount acc1;
	
	@Mock
	UserAccount acc2;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	*/
	
	UserDao ud = mock(UserDao.class);
	
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
	void testUserDao() {
		/*
		udao = Mockito.mock(UserDao.class);
		acc1 = Mockito.mock(UserAccount.class);
		Mockito.when(acc1.getEmail()).thenReturn("test@mail");
		Mockito.when(acc1.getUsername()).thenReturn("Hatter");
		Mockito.when(acc1.getPassword()).thenReturn("pass");
		*/
		UserAccount testA = new UserAccount("Hatter", "pass", 1, "MadHatter", "test@mail" );
		UserDao udao = new UserDao();
		udao.create(testA);
		
		assertEquals("test@mail", udao.read("Hatter", "pass").getEmail());
		
		UserAccount testB = new UserAccount("Hatter", "secret", 1, "Rabbit", "rabbit@gmail");
		UserAccount res = udao.update(1, testB);
		assertEquals("Rabbit", udao.read("Hatter", "secret").getHunter_name());
		assertEquals("rabbit@gmail", udao.read("Hatter", "secret").getEmail());
		
		udao.delete(res);
		assertNull(udao.read(1));
	}
	

}
