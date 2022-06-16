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
import com.example.demo.Services.DepartmentService;

@RestController
@RequestMapping("/admin")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/department")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/getDepartment")
	public List<Department> getDepartment() {
		return departmentService.getDepartment();	
	}
	
	@GetMapping("/getDataByDepartment/{DepartmentName}")
	public  ResponseEntity<List<Subject>>  getDataByDepartment(@PathVariable("DepartmentName") String DepartmentName ) {	
		return departmentService.getDataByDepartment(DepartmentName);	
	}
	
	@GetMapping("/getDataByDepartmentAndSem/{DepartmentName}/{semester}")
	public List<Subject>  getDataByDepartmentAndSem(@PathVariable("DepartmentName") String DepartmentName ,@PathVariable("semester") int semester) {
		return departmentService.getDataByDepartmentAndSem(DepartmentName,semester);		
	}
	
}
