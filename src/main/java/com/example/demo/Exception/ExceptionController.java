package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = DepartmentAlreadyExist.class)
    public ResponseEntity<Object> departmentAlreadyExist(DepartmentAlreadyExist exception) {
        return new ResponseEntity<>("Deparment  Already Exist",HttpStatus.BAD_REQUEST );
    }
	
	@ExceptionHandler(value = DepartmentNotExist.class)
	public ResponseEntity<Object> departmentNotExist(DepartmentNotExist exception)
	{
		return new ResponseEntity<>("Department Not Exist",HttpStatus.BAD_REQUEST) ;
		
	}
	
	@ExceptionHandler(value = StudentNameNotExist.class)
	public ResponseEntity<Object>  studentNameNotExist(StudentNameNotExist exception)
	{
		return new ResponseEntity<>("Student name not exist",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = SubjectAlredyExist.class)
	public ResponseEntity<Object>  SubjectAlredyExist(SubjectAlredyExist exception)
	{
		return new ResponseEntity<>("Subject name not exist",HttpStatus.BAD_REQUEST);
	}

}
