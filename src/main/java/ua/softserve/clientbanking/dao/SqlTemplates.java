package ua.softserve.clientbanking.dao;

public class SqlTemplates {
	public static final String SQL_LIST_USERS = "select users.id, users.name, users.login, roles.role_name, users.password"+
			 " from users  inner join roles on (users.role_id=roles.id)";
	public static final String SQL_FIND_USER_BY_LOGIN = SQL_LIST_USERS+" where login like ?";
	public static final String SQL_LIST_ROLES = "select * from roles";
}
