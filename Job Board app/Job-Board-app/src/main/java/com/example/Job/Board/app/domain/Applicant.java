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

    private Long applicant_id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String skills;
    private DateFormat dob;
    private Long user_id;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "JobApplicant")
    private Set<JobApplicant> jobApplicants;

    @Override
    public String toString() {
        return "Applicant [applicant_id = " + applicant_id + ", firstName = " +firstName + ", lastName = " + lastName + ", email = " + email
                + ", gender = " + gender + ", dob = " +dob+ ",user_id = " +user_id +  "]";
    }
}
