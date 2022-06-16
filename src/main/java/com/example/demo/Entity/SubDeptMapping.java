package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class SubDeptMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dept_id", referencedColumnName = "id", insertable = true)
	private Department department;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sub_id", referencedColumnName = "subjectId",insertable = true)
	private Subject subject;

	
//getter setter methods and Constructors
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubDeptMapping( Department department, Subject subject) {
		super();
		this.department = department;
		this.subject = subject;
	}
	public SubDeptMapping() {
		super();
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
