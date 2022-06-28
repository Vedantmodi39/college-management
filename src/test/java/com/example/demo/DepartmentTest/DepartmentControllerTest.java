package com.example.demo.DepartmentTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Subject;
import com.example.demo.Exception.DepartmentAlreadyExist;
import com.example.demo.Exception.DepartmentNotExist;
import com.example.demo.Services.DepartmentService;import com.example.demo.Services.SubjectServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DepartmentService departmentService;
	

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	

	@Test //post
	public void saveDepartmentTest() throws Exception  {
		Department department = new Department(1, "CE", new HashSet<Integer>(Arrays.asList(25, 54, 28)));
		
		String content=objectWriter.writeValueAsString(department);
		
		Mockito.when(departmentService.saveDepartment(department)).thenReturn(department);

		
			mockMvc.perform(MockMvcRequestBuilders
					.post("/admin/save-department")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON))

					.andExpect(content().string(content));

	}
	
	@Test //post negative
	public void saveDepartmentTest500() throws Exception  {
		Department department = new Department(1, "CE", new HashSet<Integer>(Arrays.asList(25, 54, 28)));
		
		String content=objectWriter.writeValueAsString(department);
		
		Mockito.when(departmentService.saveDepartment(department)).thenThrow(new DepartmentAlreadyExist());

		
			mockMvc.perform(MockMvcRequestBuilders
					.post("/admin/save-department")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON))

					.andExpect(status().isBadRequest());

	}
	
	
	
	
	
	@Test  //get-positive
	public void getDataByDepartmentTest() throws  Exception
	{
		 String departmentName="computer";
		 Subject s1= new Subject(1,"cc",2);
		 List<Subject> subjectList = new ArrayList<>(Arrays.asList(s1));
		 ResponseEntity<List<Subject>> reSubjectList = new ResponseEntity<List<Subject>>(subjectList,HttpStatus.OK); 
		
	
		 
		Mockito.when(departmentService.getDataByDepartment(departmentName)).thenReturn(reSubjectList);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/admin/get-data-by-department/"+departmentName)
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(content().string(objectMapper.writeValueAsString(reSubjectList.getBody())));
		
	
	}
	
	@Test  //get-negative
	public void getDataByDepartmentTest500() throws  Exception
	{
		 String departmentName="computer";
		 Subject s1= new Subject(1,"cc",2);
		 List<Subject> subjectList = new ArrayList<>(Arrays.asList(s1));
		 ResponseEntity<List<Subject>> reSubjectList = new ResponseEntity<List<Subject>>(subjectList,HttpStatus.OK); 
		
		Mockito.when(departmentService.getDataByDepartment(departmentName)).thenThrow(new DepartmentNotExist());
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/admin/get-data-by-department/"+departmentName)
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isBadRequest());
		
	
	}
	
	@Test  //get-positive
	public void getDataByDeptAndSemTest() throws Exception
	{
		
		 String departmentName="computer";
		 int semester=1;
		 Subject s1= new Subject(1,"cc",1);
		 
		 List<Subject> subjectList= new ArrayList<>(Arrays.asList(s1));
		 
		 Mockito.when(departmentService.getDataByDepartmentAndSem(departmentName, semester)).thenReturn(subjectList);
		 
		 mockMvc.perform(MockMvcRequestBuilders
				 .get("/admin/get-data-by-department-and-sem/"+departmentName+"/"+semester)
				 .contentType(MediaType.APPLICATION_JSON))
		         .andExpect(content().string(objectMapper.writeValueAsString(subjectList)));
	
		
	}
	


}
