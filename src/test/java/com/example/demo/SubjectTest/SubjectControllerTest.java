package com.example.demo.SubjectTest;

import com.example.demo.Entity.Subject;
import com.example.demo.Exception.DepartmentAlreadyExist;
import com.example.demo.Exception.SubjectAlredyExist;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Services.SubjectServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
//positiveGet	
	@MockBean
	private SubjectServices subjectServices;
	
	
	// Student s1=new Student(1,"veda",2,"CE", 706);
	Subject subject = new Subject(1, "bcs", 2);
	Subject subject2 = new Subject(2, "bcs53", 2);
	Subject subject3 = new Subject(3, "bcs", 2);

	@Test
	public void getSubjectTest() throws Exception {

		List<Subject> records = new ArrayList<>(Arrays.asList(subject, subject2, subject3));

		Mockito.when(subjectServices.getSubject()).thenReturn(records);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/admin/get-subject")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(objectMapper.writeValueAsString(records)))
				.andExpect(jsonPath("$", notNullValue()));
				//.andExpect(jsonPath("$[2].subjectName", is("bcs")));
	}
	
	//positivePost
	@Test
	public void postSubjectTest() throws Exception
	{
		
		Subject subject = new Subject(121,"Maths",3);
		Subject subject2 = new Subject(121,"Maths",3);
		Subject subject3= new Subject(121,"Maths",3);
		
		List<Subject> subList= new ArrayList<>(Arrays.asList(subject,subject2,subject3));
		
		
		String content=objectWriter.writeValueAsString(subList);
		
	   Mockito.when(subjectServices.saveSubject(subList)).thenReturn(subList);
		
	   mockMvc.perform(MockMvcRequestBuilders
			   .post("/admin/save-subject")
			   .content(content)
			   .contentType(MediaType.APPLICATION_JSON))
			   
			  // .andExpect(content().string(objectMapper.writeValueAsString(subList)));
			   .andExpect(content().string(content));
		 
		
	}
	
	
	
	//negativePost
	@Test
	public void postSubjectTest500() throws Exception
	{
		
		Subject subject = new Subject(121,"Maths",3);
		Subject subject2 = new Subject(121,"Maths",3);
		Subject subject3= new Subject(121,"Maths",3);
		
		List<Subject> subList= new ArrayList<>(Arrays.asList(subject,subject2,subject3));
		
		
		String content=objectWriter.writeValueAsString(subList);
		
	   Mockito.when(subjectServices.saveSubject(subList)).thenThrow(new SubjectAlredyExist());
		

	   
	   mockMvc.perform(MockMvcRequestBuilders
			   .post("/admin/save-subject")
			   .content(content)
			   .contentType(MediaType.APPLICATION_JSON))
			   
			  // .andExpect(content().string(objectMapper.writeValueAsString(subList)));
			   .andExpect(status().isBadRequest());
		 
	   //RuntimeException("not valid")	
	}
	
	

}