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
import com.example.demo.Exception.DepartmentAlreadyExist;
import com.example.demo.Exception.DepartmentNotExist;
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

	public Department saveDepartment(Department department) throws DepartmentAlreadyExist {

		String s=department.getName();
		
		if(departmentRepository.existsByName(s))
		{
		
			throw new DepartmentAlreadyExist();
		}

			
		Department d1 = departmentRepository.save(department);
		Set<Integer> subjectList = department.getListSubjects();
		Iterator<Integer> iterator = subjectList.iterator();
		while (iterator.hasNext()) {
			Subject s1 = subjectRepository.findById(iterator.next()).orElse(null);
			SubDeptMapping s2 = new SubDeptMapping(d1, s1);
			subDeptRepository.save(s2);
		}		
//		return new ResponseEntity<>(department,HttpStatus.OK);
		return d1;
	}
	
	

	public List<Subject> getDataByDepartmentAndSem(String departmentName, int semester) {
		List<String> list = departmentRepository.getDataByDepartmentAndSem(departmentName, semester);
		return stringToJson(list);
	}

	
	
	public ResponseEntity<List<Subject>>  getDataByDepartment(String departmentName) throws DepartmentNotExist {	
		
		if(departmentRepository.existsByName(departmentName) )
		{
			List<String> list = departmentRepository.getDataByDepartment(departmentName);
			return new ResponseEntity<>( stringToJson(list),HttpStatus.OK);
		}
		
		else
		{
			//return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST); 
			throw new DepartmentNotExist();
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
