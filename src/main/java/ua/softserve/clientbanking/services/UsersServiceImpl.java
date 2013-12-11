package ua.softserve.clientbanking.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import ua.softserve.clientbanking.DAO.UserDAO;
import ua.softserve.clientbanking.domain.User;

public class UsersServiceImpl implements IUsersService,  UserDetailsService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> loadUserList() {
		return userDAO.listUser();
	}

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		
		User user=userDAO.findUserByLogin(login);
		return user;

	}

}
