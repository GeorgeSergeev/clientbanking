package ua.softserve.clientbanking.DAO;

public class SqlScripts {
	public static final String SQL_LIST_USERS = "select user.id, user.name, user.login, roles.role from users "
			+ "inner join roles on (users.role_id=roles.id)";
	public static final String SQL_FIND_USER_BY_LOGIN = "select * from users where login = ?";
	public static final String SQL_LIST_ROLES = "select * from user_roles";
}
