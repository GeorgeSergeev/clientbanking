package ua.softserve.clientbanking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.softserve.clientbanking.domain.User;
@Service
public class UsersServiceImpl implements UsersService {

	@Override
	public List<User> loadUserList() {
		List<User> studentsList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			String role=((i%2)==0)?"Client":"Emploee";
			User student=new User(i,"Ivan"+i,"Ivan"+i,role);
			studentsList.add(student);
		}
		return studentsList;
	}

}
