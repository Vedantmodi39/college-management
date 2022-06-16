package com.example.demo.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Subject;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);
 
	
	@Query(value = "select * from subject where subject_id IN (select sub_id from dept_sub_mapping where dept_id =(select id from department where name=?1 ));", nativeQuery = true)
	List<String> getDataByDepartment(String departmentName);


	
    @Query(value = "select * from subject where subject_id IN (select sub_id from dept_sub_mapping where dept_id =(select id from department where name=?1 )and semester = ?2);",nativeQuery = true)
	List<String> getDataByDepartmentAndSem(String departmentName, int semester);



	//public static final EntityManager entityManager = null;
	
	
	
//	@Query("SELECT listSubjects FROM Department d where d.DepartmentName = ?1")
//	List<Subject> getSubjectsByDepartment(String DepartmentName);
//
//	
//	
//	@Query(value = "select department_name from Department where department_id IN (select fk_department_id from subject where subject_name = ?1)",nativeQuery = true)
//	List<String> getDepartmentBySubject(String subjectName);
//
//	@Query(value = "select semester,subject_name from subject where fk_department_id = (select department_id from department where department_name = ?1)",nativeQuery = true)
//	List<String> getDataByDepartment(String departmentName);
//
//	void exists(Department department);


	

	//@Query("SELECT listSubjects FROM Department d where d.departmentId = (SELECT s.fkStudentId FROM Student s where s.studentName = ?1)")


}
