package com.example.demo.StudentTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.Subject;
import com.example.demo.Exception.DepartmentNotExist;
import com.example.demo.Exception.StudentNameNotExist;
import com.example.demo.Services.StudentServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

	@MockBean
	StudentServices studentServices;

	@Autowired
	MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@Test
	public void getStudentByDeptTest() throws Exception {

		String deptname = "Computer";
		Student student1 = new Student(1, "Vedant", 2, "Computer", (long) 21468454);
		Student student2 = new Student(1, "Vedant", 2, "Computer", (long) 21468454);

		List<Student> list = new ArrayList<Student>(Arrays.asList(student1, student2));

		ResponseEntity<List<Student>> reList = new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		System.out.println("111");
		Mockito.when(studentServices.getStudentByDepartment(deptname)).thenReturn(reList);

		System.out.println("222");
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/get-student-by-department/" + deptname)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(objectMapper.writeValueAsString(reList.getBody())));

	}
	
	@Test
	public void getDataByStudentTest() throws  Exception
	{
		String studname="veda";
	
		Subject subject = new Subject(121,"Maths",3);
		Subject subject2 = new Subject(121,"Maths",3);
		Subject subject3= new Subject(121,"Maths",3);
		
		List<Subject> subList= new ArrayList<>(Arrays.asList(subject,subject2,subject3));
		
		Mockito.when(studentServices.getDataByStudentName(studname)).thenReturn(subList);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/admin/get-data-by-studentname/"+studname)
				.contentType(MediaType.APPLICATION_JSON))
		         .andExpect(content().string(objectMapper.writeValueAsString(subList)));
		
		
		
	}

}
