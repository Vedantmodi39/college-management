package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Department;
import com.example.demo.Entity.SubDeptMapping;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.SubDeptMappingRepository;
import com.example.demo.Repository.SubjectRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	SubDeptMappingRepository subDeptRepository;

	public ResponseEntity<Department> saveDepartment(Department department) {

		String s=department.getName();
		if(departmentRepository.existsByName(s))
		{
		
			return new ResponseEntity<> (null,HttpStatus.ALREADY_REPORTED);
		}

			
		Department d1 = departmentRepository.save(department);
		Set<Integer> subjectList = department.getListSubjects();
		Iterator<Integer> iterator = subjectList.iterator();
		while (iterator.hasNext()) {
			Subject s1 = subjectRepository.findById(iterator.next()).orElse(null);
			SubDeptMapping s2 = new SubDeptMapping(d1, s1);
			subDeptRepository.save(s2);
		}		
		return new ResponseEntity<>(department,HttpStatus.OK);
	}
	
	

	public List<Subject> getDataByDepartmentAndSem(String DepartmentName, int semester) {
		List<String> list = departmentRepository.getDataByDepartmentAndSem(DepartmentName, semester);
		return stringToJson(list);
	}

	
	
	public ResponseEntity<List<Subject>>  getDataByDepartment(String DepartmentName) {	
		
		if(departmentRepository.existsByName(DepartmentName))
		{
			List<String> list = departmentRepository.getDataByDepartment(DepartmentName);
			return new ResponseEntity<>( stringToJson(list),HttpStatus.OK);
		}
		
		else
		{
			return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST); 
		}
		

	}

	public List<Department> getDepartment() {
		return departmentRepository.findAll();
	}

	
	public List<Subject> stringToJson(List<String> list) {
		List<Subject> subList = new ArrayList<>();
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String s = it.next();
			String[] arr = s.split(",");
			Subject sub = new Subject();

			sub.setSubjectId(Integer.parseInt(arr[0]));
			sub.setSemester(Integer.parseInt(arr[1]));
			sub.setSubjectName(arr[2]);
			subList.add(sub);
		}
		return subList;
	}

}
