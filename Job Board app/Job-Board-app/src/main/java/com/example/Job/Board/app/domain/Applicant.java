package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy = AUTO)

    private Long applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String skills;
    private DateFormat dob;
    private Long userId;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "applicant")
    private Set<JobApplicant> jobApplicant;

    @Override
    public String toString() {
        return "Applicant [applicantId = " + applicantId + ", firstName = " +firstName + ", lastName = " + lastName + ", email = " + email
                + ", gender = " + gender + ", dob = " +dob+ ",userId = " +userId +  "]";
    }
}
