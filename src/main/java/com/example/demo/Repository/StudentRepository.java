package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByDepartmentName(String department);

	Student findByStudentName(String studentName);
	
	@Query(value = "select * from subject where subject_id IN (select sub_id from sub_dept_mapping where dept_id =(select id from department where name=?1 )and semester = ?2);",nativeQuery = true)
	List<String> getDataByStudentName(String departmentName, int semester);

	static boolean existsByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		return false;
	}

	boolean existsByStudentName(String studentName);

}
