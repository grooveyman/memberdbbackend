package com.grooveyman.memberdb.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grooveyman.memberdb.entity.Ministry;

public interface MinistryRepository extends JpaRepository<Ministry, UUID> {
    
}
