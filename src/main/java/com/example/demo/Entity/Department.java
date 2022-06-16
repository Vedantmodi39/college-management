package com.example.demo.Entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;



@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Transient
	private Set<Integer> listSubjects;
	
	
//	@OneToMany(targetEntity = SubDeptMapping.class , cascade = CascadeType.ALL)
//	@JoinColumn(name="fkDepartmentId",referencedColumnName = "id")
//	private List<SubDeptMapping> listDepartments;

//getter setter methods and Constructors
	
	public Department() {
		super();
	}	
	public Department(int id, String name, Set<Integer> listSubjects) {
		super();
		this.id = id;
		this.name = name;
		this.listSubjects = listSubjects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Integer> getListSubjects() {
		return listSubjects;
	}
	public void setListSubjects(Set<Integer> listSubjects) {
		this.listSubjects = listSubjects;
	}	
}
