package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Subject {

	@Id
	private int subjectId;
	private String subjectName;
	private int semester;
		
//	@ManyToOne(targetEntity = SubDeptMapping.class , cascade = CascadeType.ALL)
//	@JoinColumn(name="fkSubjectId",referencedColumnName = "subjectId")
//	private List<SubDeptMapping> listSubjects;
	
//getter setter methods and Constructors
	public Subject(int subjectId, String subjectName, int semester) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
		//this.listDepartments = listDepartments;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public Subject() {
		super();
	}
	
}
