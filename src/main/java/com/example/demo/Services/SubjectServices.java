package com.example.demo.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class SubjectServices {
	
	  @Autowired
	  DepartmentRepository departmentRepository;
	  
	  @Autowired
	  SubjectRepository subjectRepository;  

	  public List<Subject> saveSubject(List<Subject> subjectList) {	
		  return subjectRepository.saveAll(subjectList);
	  }

	  public List<Subject> getSubject() {
		  return subjectRepository.findAll();
	  }

}
