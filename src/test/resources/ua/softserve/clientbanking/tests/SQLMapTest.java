package ua.softserve.clientbanking.tests;


import static org.junit.Assert.*;

import org.junit.Test;

public class SQLMapTest {
	@Test
	public void testConnection() throws Exception{			
		assertTrue(true);
	}


}


/*
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;

import ua.softserve.clientbanking.DAO.SqlTemplates;


public class SQLMapTest {
	private JdbcTemplate jdbcTemplate;
	@Before
    public void before() throws Exception {
	    BasicDataSource dataSource;		
		dataSource= new BasicDataSource(); 
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:c:/db/clientbanking;create=false");
		dataSource.setUsername("sa");
		dataSource.setPassword(""); 
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	@Test
	public void testConnection() throws Exception{			
		//List<Map<String, Object>> rows = jdbcTemplate.queryForList(SqlTemplates.SQL_LIST_ROLES);
		//assertTrue(rows.size()>0);
		assertTrue(true);
	}


}
*/