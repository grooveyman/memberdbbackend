package com.grooveyman.memberdb.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member_ministries")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberMinistries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="member_id")
    private UUID memberId;
    
    @Column(name="ministry_id")
    private UUID ministryId;
}
