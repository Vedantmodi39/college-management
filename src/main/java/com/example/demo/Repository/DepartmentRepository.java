package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	boolean findByName(String name);
 	
	@Query(value = "select * from subject where subject_id IN (select sub_id from sub_dept_mapping where dept_id =(select id from department where name=?1 ));", nativeQuery = true)
	List<String> getDataByDepartment(String departmentName);
	
    @Query(value = "select * from subject where subject_id IN (select sub_id from sub_dept_mapping where dept_id =(select id from department where name=?1 )and semester = ?2);",nativeQuery = true)
	List<String> getDataByDepartmentAndSem(String departmentName, int semester);

	boolean findByName(Department department);

	boolean existsByName(String s);


}
