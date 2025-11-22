package com.grooveyman.memberdb.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grooveyman.memberdb.dtos.MemberDTO;
import com.grooveyman.memberdb.entity.Gender;
import com.grooveyman.memberdb.entity.MaritalStatus;
import com.grooveyman.memberdb.entity.Member;
import com.grooveyman.memberdb.entity.MemberDepartment;
import com.grooveyman.memberdb.entity.MemberMinistries;
import com.grooveyman.memberdb.entity.Ministry;
import com.grooveyman.memberdb.repository.DepartmentRepository;
import com.grooveyman.memberdb.repository.MemberDepartmentsRepository;
import com.grooveyman.memberdb.repository.MemberMinistryRepository;
import com.grooveyman.memberdb.repository.MemberRepository;
import com.grooveyman.memberdb.repository.MinistryRepository;
import com.grooveyman.memberdb.util.Engine;

import org.springframework.http.MediaType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberDepartmentsRepository memberDepartmentsRepository;
    private final MemberMinistryRepository memberMinistryRepository;

    public MemberController(MemberRepository memberRepository, MemberDepartmentsRepository memberDepartmentsRepository,
            MemberMinistryRepository memberMinistryRepository) {
        this.memberRepository = memberRepository;
        this.memberDepartmentsRepository = memberDepartmentsRepository;
        this.memberMinistryRepository = memberMinistryRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createMember(@RequestBody MemberDTO requestBody) {
        Map<String, String> response = new HashMap<>();
        // System.out.println("getting:"+requestBody.getChurchinfo().getDepartments()[0]);

        try {
            // find member
            Member exist = memberRepository.findByContact(requestBody.getBiodata().getContact()).orElse(null);
            if (exist == null) {
                Member member = new Member();
                // biodata
                UUID memId = UUID.randomUUID();
                member.setId(memId);
                member.setLastname(requestBody.getBiodata().getLastname());
                member.setOthernames(requestBody.getBiodata().getOthernames());
                member.setDateofBirth(requestBody.getBiodata().getDob());
                member.setGender(requestBody.getBiodata().getGender());
                member.setAddress(requestBody.getBiodata().getAddress());
                member.setContact(requestBody.getBiodata().getContact());
                // background
                member.setHomeTown(requestBody.getBackground().getHometown());
                member.setHomeRegion(requestBody.getBackground().getHomeregion());
                member.setMaritalStatus(requestBody.getBackground().getMaritalstatus());
                member.setSpouseName(requestBody.getBackground().getSpouse());
                member.setProfession(requestBody.getBackground().getProfession());
                member.setEduLevel(requestBody.getBackground().getEdulevel());

                member.setChurchBaptism(requestBody.getChurchinfo().getChurchbaptism());
                member.setChurchRole(requestBody.getChurchinfo().getChurchrole());

                // image
                if (requestBody.getImage() != null) {
                    String path = Engine.saveBase64Image(requestBody.getImage().getImage(), "uploads");
                    member.setImgUrl(path);
                }

                memberRepository.save(member);
                // churchinfo
                for (String dept : requestBody.getChurchinfo().getDepartments()) {
                    MemberDepartment memDept = new MemberDepartment();
                    memDept.setMemberId(memId);
                    memDept.setDepartmentId(UUID.fromString(dept));
                    memberDepartmentsRepository.save(memDept);
                }

                for (String min : requestBody.getChurchinfo().getMinistries()) {
                    MemberMinistries memMin = new MemberMinistries();
                    memMin.setMemberId(memId);
                    memMin.setMinistryId(UUID.fromString(min));
                    memberMinistryRepository.save(memMin);
                }

                response.put("message", "successfully created member");
                return ResponseEntity.status(HttpStatus.OK).body(response);

            } else {
                response.put("error", "Member already registered");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

          
        } catch (Exception e) {
            response.put("error", "Failed to create member:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        // log.info("Request body: {}", requestBody.getImage().getImage().toString())

    }
}
