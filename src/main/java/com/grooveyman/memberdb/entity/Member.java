package com.grooveyman.memberdb.entity;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
   @Column(name="id")
    private UUID id;

    @Column(name="lastname")
    private String lastname;

    @Column(name="othernames")
    private String othernames;

    @Column(name="dob")
    private LocalDate dateofBirth;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="contact")
    private String contact;

    @Column(name="address")
    private String address;

    @Column(name="hometown")
    private String homeTown;

    @Column(name="homeregion")
    private String homeRegion;

    @Column(name="marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name="hometown_region")
    private String homeTownRegion;

    @Column(name="spouse_name")
    private String spouseName;

    @Column(name="edulevel")
    private String eduLevel;

    @Column(name="profession")
    private String profession;

    @Column(name="church_baptism")
    private String churchBaptism;

    @Column(name="church_role")
    private String churchRole;

    // @ManyToMany
    // @JoinTable(name="member_ministries", joinColumns = @JoinColumn(name="member_id"), inverseJoinColumns = @JoinColumn(name="ministry_id"))
    // private Set<Ministry> ministries;
    // @Column(name="")

    // @ManyToMany
    // @JoinTable(name="member_departments", joinColumns = @JoinColumn(name="member_id"), inverseJoinColumns = @JoinColumn(name="department_id"))
    // private Set<Department> departments;

    @Column(name="img_url", columnDefinition = "TEXT")
    private String imgUrl;
}
