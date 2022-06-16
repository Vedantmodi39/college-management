package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	boolean existsDepartmentBySubjectName(String subjectName);
	boolean existsBySubjectName(String subjectName);
	
}
