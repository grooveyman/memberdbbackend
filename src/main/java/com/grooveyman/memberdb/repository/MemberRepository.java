package com.grooveyman.memberdb.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grooveyman.memberdb.entity.Member;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByContact(String contact);
}
