package com.grooveyman.memberdb.dtos;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.grooveyman.memberdb.entity.Department;
import com.grooveyman.memberdb.entity.Gender;
import com.grooveyman.memberdb.entity.MaritalStatus;
import com.grooveyman.memberdb.entity.Ministry;

import lombok.Data;
@Data
public class MemberDTO {

    private Biodata biodata;
    private Background background;
    private ChurchInfo churchinfo;
    private Image image;

    @Data
    public static class Biodata {
        private String lastname;
        private String othernames;
        private LocalDate dob;
        private Gender gender;
        private String contact;
        private String address;
    }

    @Data
    public static class Background {
        private String hometown;
        private String homeregion;
        private MaritalStatus maritalstatus;
        private String spouse;
        private String profession;
        private String edulevel;
    }

    @Data
    public static class ChurchInfo {
        private String[] ministries;         // receive IDs from frontend
        private String[] departments;      // receive IDs from frontend
        private String churchbaptism;
        private String churchrole;
    }

    @Data
    public static class Image {
        private String image; // base64
    }
}