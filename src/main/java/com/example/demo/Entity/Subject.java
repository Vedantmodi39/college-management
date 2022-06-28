package com.example.demo.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data

@NoArgsConstructor
public class Subject {

	@Id
	private int subjectId;
	private String subjectName;
	private int semester;
	

	
	
		
	public String toStringCustom() {
		return subjectId+","+ subjectName + "," + semester;
	}





	public Subject(int subjectId, String subjectName, int semester) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
	}





	public Subject(int subjectId, int semester,String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
	}
	
	
//	@ManyToOne(targetEntity = SubDeptMapping.class , cascade = CascadeType.ALL)
//	@JoinColumn(name="fkSubjectId",referencedColumnName = "subjectId")
//	private List<SubDeptMapping> listSubjects;
	
//getter setter methods and Constructors


}
