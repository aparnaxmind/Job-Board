package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import java.text.DateFormat;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApplicantDetails {
    private Long applicant_id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Gender;
    private String Skills;
    private DateFormat DOB;
    private Long user_id;
}
