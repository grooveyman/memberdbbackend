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
@Table(name="member_departments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "member_id")
    private UUID memberId;

    @Column(name="department_id")
    private UUID departmentId;
}
