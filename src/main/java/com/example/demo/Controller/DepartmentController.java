package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Department;
import com.example.demo.Entity.Subject;
import com.example.demo.Exception.DepartmentAlreadyExist;
import com.example.demo.Exception.DepartmentNotExist;
import com.example.demo.Services.DepartmentService;

@RestController
@RequestMapping("/admin")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/save-department")
	public Department saveDepartment(@RequestBody Department department) throws DepartmentAlreadyExist {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/get-department")
	public List<Department> getDepartment() {
		return departmentService.getDepartment();	
	}
	
	@GetMapping("/get-data-by-department/{departmentName}")
	public  ResponseEntity<List<Subject>>  getDataByDepartment(@PathVariable("departmentName") String departmentName ) throws DepartmentNotExist {	
		return departmentService.getDataByDepartment(departmentName);	
	}
	
	@GetMapping("/ge-data-by-department-and-sem/{departmentName}/{semester}")
	public List<Subject>  getDataByDepartmentAndSem(@PathVariable("departmentName") String departmentName ,@PathVariable("semester") int semester) {
		return departmentService.getDataByDepartmentAndSem(departmentName,semester);		
	}
	
}
