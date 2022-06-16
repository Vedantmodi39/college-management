package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Subject;
import com.example.demo.Services.SubjectServices;


@RestController
@RequestMapping("/admin")
public class SubjectController {
	

	
	@Autowired
	SubjectServices subjectServices;
	
	@PostMapping("/subject")
	public List<Subject> saveSubject(@RequestBody List<Subject> subject) {
		
		return subjectServices.saveSubject(subject);
	
	}
	
	@GetMapping("/getSubject")
	public List<Subject> getSubject() {
		
		return subjectServices.getSubject();
		
	}
	
	
	
//	@GetMapping("/getDepartmentBySubject/{subjectName}")
//	public List<Department> getDepartmentBySubject(@PathVariable("subjectName") String subjectName) {
//		return departmentRepository.getDepartmentBySubject(subjectName);
//	}
//	
//	
//	@GetMapping("/getDepartmentBySubject/{subjectName}")
//	public List<String> getDepartmentBySubject(@PathVariable("subjectName") String subjectName) {
//		return departmentRepository.getDepartmentBySubject(subjectName);
//	}
//	
//	
//	
//	@GetMapping("/getSubjectBySemester/{DepartmentName}/{semester}")
//	public List<Subject> getSubjectBySemester(@PathVariable("semester") int semester , @PathVariable("DepartmentName") String DepartmentName) {
//		
//		List<Subject>subList = departmentRepository.getSubjectsByDepartment(DepartmentName) ; 
//		//return subjectRepository.findBySemester(semester);
//		List<Subject> res = new ArrayList<>();
//		
//		Iterator<Subject> it= subList.iterator();
//		
//		while(it.hasNext()) {
//			Subject obj = it.next(); 
//			if( obj.getSemester()==semester  ) {
//				res.add(obj);
//			}
//		}
//		
//		
//		return res;
//		
//		
//	}
//	

}
