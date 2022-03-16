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


    @Enumerated(EnumType.ORDINAL)
    private JobApplicant.Status status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="applicantId",referencedColumnName = "applicantId")
    private  Applicant applicant;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="jobId",referencedColumnName = "jobId")
    private  Jobs jobs;
}
