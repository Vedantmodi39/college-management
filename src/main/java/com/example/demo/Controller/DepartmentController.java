package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.DeptSubMapping;
import com.example.demo.Entity.Subject;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.DeptSubMappingRepository;
import com.example.demo.Repository.SubjectRepository;
import com.example.demo.Services.DepartmentService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/admin")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	  @Autowired
	   DepartmentRepository departmentRepository;
	  
	  @Autowired
	  SubjectRepository subjectRepository;
	  
	  @Autowired
	  DeptSubMappingRepository deptSubMappingRepository;
	  

	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
	
		return departmentService.saveDepartment(department);
	}
	

	@GetMapping("/getDepartment")
	public List<Department> getDepartment() {
		
		return departmentService.getDepartment();	
	}
	
	@GetMapping("/getDataByDepartment/{DepartmentName}")
	public List<String> getDataByDepartment(@PathVariable("DepartmentName") String DepartmentName ) {
		
		return departmentService.getDataByDepartment(DepartmentName);
		
	}
	
	@GetMapping("/getDataByDepartmentAndSem/{DepartmentName}/{semester}")
	public List<Subject> getDataByDepartmentAndSem(@PathVariable("DepartmentName") String DepartmentName ,@PathVariable("semester") int semester) {

		return departmentService.getDataByDepartmentAndSem(DepartmentName,semester);
		
		
	}
	
	
	
}
