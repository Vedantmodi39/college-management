package com.example.demo.Entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	

}
