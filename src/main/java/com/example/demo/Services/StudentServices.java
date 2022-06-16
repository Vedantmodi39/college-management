package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DeptSubMappingRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class StudentServices {
	
	   @Autowired
	   DepartmentRepository departmentRepository;
	  
	  @Autowired
	  StudentRepository studentRepository;
	  
	  @Autowired
	  DeptSubMappingRepository deptSubMappingRepository;

	public List<String> getDataByStudentName(String studentName) {
		
	
		Student student=studentRepository.findByStudentName(studentName);
	
       return studentRepository.getDataByStudentName(student.getDepartmentName(), student.getSemester());
       
	}

	public List<Student> getStudentByDepartment(String department) {
		
		 return studentRepository.findByDepartmentName(department);
		
	}

	public List<Student> getStudent() {
		
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}	
}
