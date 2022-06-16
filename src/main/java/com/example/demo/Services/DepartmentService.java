package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.DeptSubMapping;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DeptSubMappingRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class DepartmentService {
	
	@Autowired
	   DepartmentRepository departmentRepository;
	  
	  @Autowired
	  SubjectRepository subjectRepository;
	  
	  @Autowired
	  DeptSubMappingRepository deptSubMappingRepository;
	  
	  
	  
	  
	  
	
public Department saveDepartment(Department department) {
			
			Department d1= departmentRepository.save(department);
		    List<Integer> subjectList = department.getListSubjects();
			
			
			subjectList.stream().map(t -> subjectRepository.findById(t)).collect(Collectors.toList());
			Iterator<Integer> iterator= subjectList.iterator();
			
			while(iterator.hasNext()) 
			{
				Subject s1=subjectRepository.findById(iterator.next()).orElse(null);
				
				deptSubMappingRepository.save(new DeptSubMapping(d1.getId(),s1.getSubjectId()));
			}
			
			
			return d1;
			
		}






        public List<Subject> getDataByDepartmentAndSem(String DepartmentName, int semester) {
			
			List<Subject> subList = new ArrayList<>();

			
			List<String> list= departmentRepository.getDataByDepartmentAndSem(DepartmentName,semester);
			
			Iterator<String> it = list.iterator();
			while(it.hasNext()) {
			String s = it.next();

			System.out.println(s);
			
			
				String[] arr = s.split(",");
				Subject sub = new Subject();
				
				sub.setSubjectId(Integer.parseInt(arr[0]));
				sub.setSemester(Integer.parseInt(arr[1]));
				sub.setSubjectName(arr[2]);
				
				subList.add(sub);
				
			}
			return subList;
			
		}



public List<String> getDataByDepartment(String DepartmentName) {
			
			return departmentRepository.getDataByDepartment(DepartmentName);
		}


public List<Department> getDepartment() {
			return departmentRepository.findAll();
		}
		


}
