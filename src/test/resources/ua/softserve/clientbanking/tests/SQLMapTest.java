package ua.softserve.clientbanking.tests;


import static org.junit.Assert.*;

import org.junit.Test;

/*
public class SQLMapTest {
	@Test
	public void testConnection() throws Exception{			
		assertTrue(true);
	}


}

*/



import java.util.List;
import java.util.Map;




import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;

import ua.softserve.clientbanking.dao.SqlTemplates;
import ua.softserve.clientbanking.dao.UserDaoImpl;
import ua.softserve.clientbanking.domain.User;


public class SQLMapTest {
	private JdbcTemplate jdbcTemplate;
	private BasicDataSource dataSource;
	
	@Before
    public void before() throws Exception {	    		
		dataSource= new BasicDataSource(); 
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:c:/db/clientbankingtest;create=false");
		dataSource.setUsername("sa");
		dataSource.setPassword(""); 
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	@Test
	public void testConnection() throws Exception{			
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SqlTemplates.SQL_LIST_ROLES);
		assertTrue(rows.size()>0);
	}
	
	@Test
	public void testFindUserByLogin() throws Exception{
	    UserDaoImpl userDao=givenUserDao();
		User user=whenUserIsFound(userDao, "user1");		
		thenUser1MustBe(user);
	}

	private UserDaoImpl givenUserDao() {
		UserDaoImpl userDaoImpl= new UserDaoImpl();
		userDaoImpl.setDataSource(dataSource);
		return userDaoImpl;
	}
	
	private User whenUserIsFound(UserDaoImpl userDaoImpl, String userLogin) {
		User user=userDaoImpl.findUserByLogin(userLogin);
		return user;
	}

	private void thenUser1MustBe(User user) {
		assertFalse(null==user);
		assertEquals("user1", user.getName());
	}
	


}
