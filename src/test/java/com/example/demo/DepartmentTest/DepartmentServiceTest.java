package com.example.demo.DepartmentTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Subject;
import com.example.demo.Exception.DepartmentAlreadyExist;
import com.example.demo.Exception.DepartmentNotExist;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Services.DepartmentService;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest {
	
	@MockBean
	DepartmentRepository departmentRepository;
	
	@Autowired
     DepartmentService departmentService;
	
	
	
	@Test
	public void saveDepartmentTest() throws DepartmentAlreadyExist
	{
		
		Department department = new Department(1, "CE", new HashSet<Integer>(Arrays.asList(25, 54, 28)));
		
		Mockito.when(departmentRepository.save(department)).thenReturn(department);
		
		assertThat(departmentService.saveDepartment(department)).isEqualTo(department);
			
	}
	
	@Test
	public void getDataByDepartmentTest() throws DepartmentNotExist
	{
		Subject s1= new Subject(1,"cc",2);
		List<Subject> sublist = new ArrayList<>(Arrays.asList(s1));
      
        List<String> listString = new ArrayList<String>();
        
        ResponseEntity<List<Subject>> reEntity = new ResponseEntity<List<Subject>>(sublist,HttpStatus.OK);
        
		//List<String> list= new ArrayList<>();
		for(int i=0 ; i<sublist.size() ; i++ ) {
			listString.add( sublist.get(i).toStringCustom());
		}

		String departmentName="computer";

		Mockito.when(departmentRepository.existsByName(departmentName)).thenReturn(true);
		Mockito.when(departmentRepository.getDataByDepartment(departmentName)).thenReturn(listString);

		assertThat(departmentService.getDataByDepartment(departmentName)).isEqualTo(reEntity);
		
			
	}
	
	@Test  //get-positive
	public void getDataByDeptAndSemTest() throws Exception
	{
		
		 String departmentName="computer";
		 int semester=1;
		 Subject s1= new Subject(1,"cc",1);
		 
		 List<Subject> subjectList= new ArrayList<>(Arrays.asList(s1));
		 List<String>  stringList= new ArrayList<>();
		 
		 for(int i=0;i<subjectList.size();i++)
		 {
			 stringList.add(subjectList.get(i).toStringCustom());
		 }
		 
		 
		 Mockito.when(departmentRepository.getDataByDepartmentAndSem(departmentName, semester)).thenReturn(stringList);
		 
		 assertThat(departmentService.getDataByDepartmentAndSem(departmentName, semester)).isEqualTo(subjectList);
		 
		 
		
	}
	


}

