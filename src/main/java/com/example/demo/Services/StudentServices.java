package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.StudentRepository;


@Service
public class StudentServices {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	StudentRepository studentRepository;

	public List<Subject> getDataByStudentName(String studentName) {

		List<Subject> subList = new ArrayList<>();
		Student stud = studentRepository.findByStudentName(studentName);
		List<String> list = studentRepository.getDataByStudentName(stud.getDepartmentName(), stud.getSemester());
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {

			String s = iterator.next();
			String[] arr = s.split(",");
			Subject sub = new Subject();

			sub.setSubjectId(Integer.parseInt(arr[0]));
			sub.setSemester(Integer.parseInt(arr[1]));
			sub.setSubjectName(arr[2]);
			subList.add(sub);
		}

		return subList;
	}

	public ResponseEntity<List<Student>> getStudentByDepartment(String department) {
		
		if(departmentRepository.existsByName(department))
		{
			return new ResponseEntity<List<Student>>(studentRepository.findByDepartmentName(department),HttpStatus.OK);

		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	
		
	}

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}
