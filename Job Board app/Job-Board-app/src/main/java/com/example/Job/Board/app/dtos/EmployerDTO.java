package com.example.Job.Board.app.dtos;

import lombok.Data;

@Data
public class EmployerDTO {
    private Long employerId;
    private String companyName;
    private String address;
    private String city;
    private String state;
    private String email;
    private String website;
    private String mobileNo;
    private Long userId;
}
