package com.grooveyman.memberdb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grooveyman.memberdb.entity.Ministry;
import com.grooveyman.memberdb.repository.MinistryRepository;

@RestController
@RequestMapping("/api/ministries")
public class MinistryController {
    private final MinistryRepository ministryRepository;

    public MinistryController(MinistryRepository ministryRepository){
        this.ministryRepository = ministryRepository;
    }

    @PostMapping
    public Ministry createMinistry(@RequestBody Ministry ministry){
        return ministryRepository.save(ministry);
    }

    @GetMapping
    public List<Ministry> getAllMinistries(){
        return ministryRepository.findAll();
    }
}
