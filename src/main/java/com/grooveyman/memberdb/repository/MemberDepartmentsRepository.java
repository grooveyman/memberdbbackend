package com.grooveyman.memberdb.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grooveyman.memberdb.entity.MemberDepartment;

public interface MemberDepartmentsRepository extends JpaRepository<MemberDepartment, UUID> {
    
}
