package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	private int subjectId;
	private String subjectName;
	private int semester;
	
	
//	
//	@ManyToOne(targetEntity = Department.class , cascade = CascadeType.ALL)
//	@JoinColumn(name="fkSubjectId",referencedColumnName = "subjectId")
//	private List<Department> listDepartments;



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
