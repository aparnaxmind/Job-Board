package com.example.Job.Board.app.dtos;

import lombok.Data;

import java.text.DateFormat;
@Data
public class ApplicantDTO {
    private Long applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String skills;
    private DateFormat dob;
    private Long userId;
}
