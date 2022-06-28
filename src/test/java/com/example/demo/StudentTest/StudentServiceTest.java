package com.example.demo.StudentTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subject;
import com.example.demo.Exception.StudentNameNotExist;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Services.StudentServices;
import com.example.demo.Services.SubjectServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceTest {
	
	
	@MockBean
	StudentRepository studentRepository;

	@Autowired
	StudentServices studentServices;
	
	@MockBean
	DepartmentRepository departmentRepository;
	

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Test
	public void getStudentByDeptTest() throws Exception {

		String deptname = "Computer";
		Student student1 = new Student(1, "Vedant", 2, "Computer", (long) 21468454);
		Student student2 = new Student(1, "Vedant", 2, "Computer", (long) 21468454);

		List<Student> list = new ArrayList<Student>(Arrays.asList(student1, student2));

		ResponseEntity<List<Student>> reList = new ResponseEntity<List<Student>>(list, HttpStatus.OK);

	
		
		Mockito.when(departmentRepository.existsByName(deptname)).thenReturn(true);
		Mockito.when(studentRepository.findByDepartmentName(deptname)).thenReturn(list);

		
		assertThat(studentServices.getStudentByDepartment(deptname)).isEqualTo(reList);
		
	}
	
	
	
	@Test
	public void getDataByStudentNameTest() throws StudentNameNotExist {
		String studentName = "Vedant";

		Student student1 = new Student(1, "Vedant", 2, "Computer", (long) 21468454);

		Subject subject = new Subject(102, 3, "Maths");
		Subject subject2 = new Subject(110, 3, "Maths");
		// Subject subject3= new Subject(120,"Maths",3);

		String name = "Computer";
		int sem = 2;

		List<Subject> subList = new ArrayList<>(Arrays.asList(subject, subject2));

		List<String> strl = new ArrayList<String>();
		strl.add("102,3,Maths");
		strl.add("110,3,Maths");

		Mockito.when(studentRepository.existsByStudentName(studentName)).thenReturn(true);

		Mockito.when(studentRepository.findByStudentName(studentName)).thenReturn(student1);

		Mockito.when(studentRepository.getDataByStudentName(name, sem)).thenReturn(strl);

		assertThat(studentServices.getDataByStudentName(studentName)).isEqualTo(subList);

	}

}
