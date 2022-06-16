package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByDepartmentName(String department);

	Student findByStudentName(String studentName);
	
	@Query(value = "select * from subject where subject_id IN (select sub_id from dept_sub_mapping where dept_id =(select id from department where name=?1 )and semester = ?2);",nativeQuery = true)
	List<String> getDataByStudentName(String departmentName, int semester);
	
//	@Query(value = "select * from subject where subject_id IN (select sub_id from dept_sub_mapping where dept_id =(select id from department where name=?1 )and semester = ?2);",nativeQuery = true)
//	List<String> getDataByStudentName(String departmentName, int semester);

//	@Query(value = "  ", nativeQuery = true)
//	List<Student> getDataByStudentName(String studentName);



	
	
//	@Query(value = "select * from Student where department= ?1;",nativeQuery = true)
//	List<String> getStudentByDepartment(String department);

//	@Query(value = "select * from Student where department= ?1;",nativeQuery = true)
//	List<Student> getStudentByDepartment(String department);

}
