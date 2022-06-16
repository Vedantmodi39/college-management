package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
