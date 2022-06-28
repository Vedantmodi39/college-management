package com.example.demo;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entity.UserRegister;
import com.example.demo.Services.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;




@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {

        @Autowired
	private MockMvc mockMvc;
	
	
    ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();


    @MockBean
	private RegisterService registerService;
    

	//UserRegister userRegister = new UserRegister(12, "username1", "passs1", "admin");
	//UserRegister userRegister2 = new UserRegister(13, "usernam1", "pass1", "admin");



	@Test
	public void posttData() throws Exception
	{
	    //Subject subject = new Subject(121,"C++",3);
	      UserRegister userRegister = new UserRegister(1,"ved","abc","Admin");
	      
	      //  List<Subject> records = new ArrayList<>(Arrays.asList(subject,subject1));
	      String content1=objectWriter.writeValueAsString(userRegister);
	      // to convert in a string
	      System.out.println("userRegister "+ userRegister);
	      System.out.println("content "+ content1);
	      
	      Mockito.when(registerService.adminLogin(userRegister)).thenReturn(userRegister);
	      
	      mockMvc.perform(MockMvcRequestBuilders
	                  .post("/register/admin")
	                  .content(content1)
	                  .contentType(MediaType.APPLICATION_JSON))
	          
	                  .andExpect(content().string(objectMapper.writeValueAsString(userRegister)))
	                  .andExpect(jsonPath("$.username", is("ved")));
	      	      
	}
	





	
	

}
