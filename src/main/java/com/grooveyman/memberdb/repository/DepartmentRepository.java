package com.grooveyman.memberdb.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grooveyman.memberdb.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, UUID>{
    
}
