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
import com.example.demo.Exception.DepartmentNotExist;
import com.example.demo.Exception.StudentNameNotExist;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	StudentRepository studentRepository;

	public List<Subject> getDataByStudentName(String studentName) throws StudentNameNotExist {

		List<Subject> subList = new ArrayList<>();

		if (studentRepository.existsByStudentName(studentName)) {

			Student stud = studentRepository.findByStudentName(studentName);
		
			List<String> list = studentRepository.getDataByStudentName(stud.getDepartmentName(), stud.getSemester());
			Iterator<String> iterator = list.iterator();

			while (iterator.hasNext()) {

				String s = iterator.next();
				String[] arr = s.split(",");
				Subject sub = new Subject();

				sub.setSubjectId(Integer.parseInt(arr[0]));
				sub.setSubjectName(arr[2]);
				sub.setSemester(Integer.parseInt(arr[1]));
				
				subList.add(sub);
				
			}
			
		}

		else 
		{
			throw new StudentNameNotExist();

		}
		return subList;

	}

	public ResponseEntity<List<Student>> getStudentByDepartment(String department) throws DepartmentNotExist {

		if (departmentRepository.existsByName(department)) {
			return new ResponseEntity<List<Student>>(studentRepository.findByDepartmentName(department), HttpStatus.OK);

		} else {
			throw new DepartmentNotExist();
		}

	}

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}
