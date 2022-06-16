package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DeptSubMappingRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class SubjectServices {
	
	
	@Autowired
	   DepartmentRepository departmentRepository;
	  
	  @Autowired
	  SubjectRepository subjectRepository;
	  
	  @Autowired
	  DeptSubMappingRepository deptSubMappingRepository;

	public List<Subject> saveSubject(List<Subject> subjectList) {
		
		ArrayList<Subject> stylistsArr=new ArrayList<Subject>();
		
		for(int i=0;i<subjectList.size();i++)
		{
			stylistsArr.add(subjectList.get(i));
		}
		
		
		return subjectRepository.saveAll(stylistsArr);
	}

	public List<Subject> getSubject() {
		return subjectRepository.findAll();
	}

}
