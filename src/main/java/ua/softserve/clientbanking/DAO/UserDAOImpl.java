package ua.softserve.clientbanking.DAO;

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

public class UserDAOImpl implements UserDAO {
	
	private static final String SQL_LIST_USERS = "select user.id, user.name, user.login, roles.role from users "
			+ "inner join roles on (users.role_id=roles.id)";
	private static final String SQL_FIND_USER_BY_LOGIN = "select * from users where login = ?";

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> listUser() {
		String sql = SQL_LIST_USERS;

		List<User> users = new ArrayList<User>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			User user = new User((int) row.get("id"), (String) row.get("name"),
					(String) row.get("login"), (String) row.get("role"));
			users.add(user);
		}

		return users;
	}

	@Override
	public User findUserByLogin(String login) throws ObjectNotFoundException {
		String sql = SQL_FIND_USER_BY_LOGIN;
		RowMapper<User> mapper = new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User User = new User(rs.getInt("id"), rs.getString("name"),
						rs.getString("login"), rs.getString("role"));
				return User;
			}
		};
		User user = (User) jdbcTemplate.queryForObject(sql,
				new Object[] { login }, mapper);
		if (null == user) {
			throw new ObjectNotFoundException(User.class, login);
		}
		return user;
	}
}
