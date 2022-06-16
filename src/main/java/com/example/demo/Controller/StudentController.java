package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subject;
import com.example.demo.Services.StudentServices;

@RestController
@RequestMapping("/admin")
public class StudentController {

	@Autowired
	StudentServices studentServices;
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {	
		return studentServices.saveStudent(student);		
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudent() {
		return studentServices.getStudent();
	}
	
	@GetMapping("/getStudentByDepartment/{departmentName}")
	public ResponseEntity<List<Student>>  getStudentByDepartment(@PathVariable("departmentName") String department){
		return studentServices.getStudentByDepartment(department);	
	}
	
	@GetMapping("/getDataByStudentName/{studentName}")
	public List<Subject> getDataByStudentName(@PathVariable("studentName") String studentName){
	   return studentServices.getDataByStudentName(studentName);  
	}

}
