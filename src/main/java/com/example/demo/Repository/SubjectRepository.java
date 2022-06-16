package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	boolean existsDepartmentBySubjectName(String subjectName);

	boolean existsBySubjectName(String subjectName);

	
	

//	@Query("select listDepartments from Subject s where s.subjectName = ?1")
//	Department getDepartmentBySubject(String subjectName);




	// List<Subject> findByDepartment(long departmentId);



}
