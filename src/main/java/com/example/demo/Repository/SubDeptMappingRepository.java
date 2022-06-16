package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.SubDeptMapping;

@Repository
public interface SubDeptMappingRepository extends JpaRepository<SubDeptMapping, Integer> {

}
