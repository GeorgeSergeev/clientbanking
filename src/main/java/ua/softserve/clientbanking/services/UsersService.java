package ua.softserve.clientbanking.services;

import java.util.List;

import ua.softserve.clientbanking.domain.User;

public interface UsersService {
	List <User> loadUserList();
}
