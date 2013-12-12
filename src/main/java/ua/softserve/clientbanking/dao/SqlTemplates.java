package ua.softserve.clientbanking.dao;

public class SqlTemplates {
	public static final String SQL_LIST_USERS = "select user_info.id, user_info.name, user_info.login, user_roles.role_name, user_info.password"+
			 " from user_info  inner join user_roles on (user_info.role_id=user_roles.id)";
	public static final String SQL_FIND_USER_BY_LOGIN = SQL_LIST_USERS+" where login like ?";
	public static final String SQL_LIST_ROLES = "select * from user_roles";
}
