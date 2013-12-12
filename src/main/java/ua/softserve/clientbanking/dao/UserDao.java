package ua.softserve.clientbanking.dao;

import java.util.List;

import ua.softserve.clientbanking.domain.User;
import ua.softserve.clientbanking.exceptions.ObjectNotFoundException;

public interface UserDao {

//	public void addUser(User user);
	public List<User> listUser();
	public User findUserByLogin(String login) throws ObjectNotFoundException;
	
}