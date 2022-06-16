package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Transient
	private List<Integer> listSubjects;
	
	
	
	
	

	public Department() {
		super();
	}
	
	
	public Department(int id, String name, List<Integer> listSubjects) {
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
	public List<Integer> getListSubjects() {
		return listSubjects;
	}
	public void setListSubjects(List<Integer> listSubjects) {
		this.listSubjects = listSubjects;
	}
	
	

	



	
	
	
}
