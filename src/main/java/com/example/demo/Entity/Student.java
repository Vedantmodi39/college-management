package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private int semester;
	private String departmentName;
	private Long studentContact;
	
//getter setter methods and Constructors	
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, int semester, String departmentName, Long studentContact) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.semester = semester;
		this.departmentName = departmentName;
		this.studentContact = studentContact;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(Long studentContact) {
		this.studentContact = studentContact;
	}	
}
