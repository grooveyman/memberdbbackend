package com.grooveyman.memberdb.entity;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ministry")
@NoArgsConstructor
@AllArgsConstructor
public class Ministry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="name")
    private String name;

    // @Column(name="ministries")
    // @ManyToMany(mappedBy = "ministries")
    // @JsonIgnore
    // private Set<Member> members;

    
}
