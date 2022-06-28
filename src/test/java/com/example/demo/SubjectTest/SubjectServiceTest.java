package com.example.demo.SubjectTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Entity.Subject;
import com.example.demo.Exception.SubjectAlredyExist;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Services.SubjectServices;

@SpringBootTest
@AutoConfigureMockMvc
public class SubjectServiceTest {
	
// je vstu ne actual ma mock krvanu hoy je aapde mockito ma nkhta hoi ae when ma..
	@MockBean
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectServices subjectServices;
	
	@Test
	public void getSubjectTestService() throws SubjectAlredyExist
		{
		
		Subject subject = new Subject(121,"Maths",3);
		Subject subject2 = new Subject(121,"Maths",3);
		Subject subject3= new Subject(121,"Maths",3);
		
		List<Subject> subList= new ArrayList<>(Arrays.asList(subject,subject2,subject3));
		
		Mockito.when(subjectRepository.saveAll(subList)).thenReturn(subList);
		
		assertThat(subjectServices.saveSubject(subList)).isEqualTo(subList);
		
		}
	
	@Test
	public void postSubjectTestService()
	{
		Subject subject = new Subject(121,"Maths",3);
		Subject subject2 = new Subject(121,"Maths",3);
		Subject subject3= new Subject(121,"Maths",3);
		
		List<Subject> subList = new ArrayList<>(Arrays.asList(subject,subject2,subject3));
		
		Mockito.when(subjectRepository.findAll()).thenReturn(subList);
		assertThat(subjectServices.getSubject()).isEqualTo(subList);
	}

}
