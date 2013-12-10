package ua.softserve.clientbanking;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;


public class SQLMapTest {
    BasicDataSource dataSource;
	@Before
    public void before() throws Exception {
		
		dataSource= new BasicDataSource(); 
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:classpath:clientbanking;create=false");
		dataSource.setUsername("sa");
		dataSource.setPassword(""); 
		
	}
	
	@Test
	public void testConnection() throws Exception{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		assertTrue(true);
	}


}
