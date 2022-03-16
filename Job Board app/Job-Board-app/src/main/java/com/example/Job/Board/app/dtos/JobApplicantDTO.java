package com.example.Job.Board.app.dtos;

import com.example.Job.Board.app.domain.JobApplicant;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class JobApplicantDTO {

    private Long Id;
    private Long job_id;
    private String applicant_id;

    @Enumerated(EnumType.ORDINAL)
    private JobApplicant.Status status;
}
