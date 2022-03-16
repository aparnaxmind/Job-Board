package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JobApplicant {

    public enum Status {
        APPLIED, HIRED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long job_id;
    private String applicant_id;

    @Enumerated(EnumType.ORDINAL)
    private JobApplicant.Status status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="applicant_id",referencedColumnName = "applicant_id")
    private  Applicant applicant;
}
