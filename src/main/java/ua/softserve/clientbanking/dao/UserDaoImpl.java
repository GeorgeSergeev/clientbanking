package ua.softserve.clientbanking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ua.softserve.clientbanking.domain.User;
import ua.softserve.clientbanking.exceptions.ObjectNotFoundException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {
	
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

/*	
	@Override
	public void addUser(User user) {
		

	}
*/
	@Override
	public List<User> listUser() {
		List<User> users = new ArrayList<User>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SqlTemplates.SQL_LIST_USERS);
		for (Map<String, Object>row : rows) {
			User user = new User((int) row.get("id"), (String) row.get("name"),
					(String) row.get("login"), (String) row.get("role_name"), (String) row.get("password"));
			users.add(user);
		}

		return users;
	}

	@Override
	public User findUserByLogin(String login) throws ObjectNotFoundException {	
		RowMapper<User> mapper = new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User User = new User(rs.getInt("id"), rs.getString("name"),
						rs.getString("login"), rs.getString("role_name"), rs.getString("password"));
				return User;
			}
		};
		User user = (User) jdbcTemplate.queryForObject(SqlTemplates.SQL_FIND_USER_BY_LOGIN,
				new Object[] { login }, mapper);
		if (null == user) {
			throw new ObjectNotFoundException(User.class, login);
		}
		return user;
	}
}
