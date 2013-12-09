package ua.softserve.clientbanking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.softserve.clientbanking.student.Student;
@Service
public class StudentsServiceImpl implements StudentsService {

	@Override
	public List<Student> loadStudentList() {
		List<Student> studentsList = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			Student student=new Student(i,"Ivan"+i,i);
			studentsList.add(student);
		}
		return studentsList;
	}

}
