package com.example.Job.Board.app.dtos;

import lombok.Data;

@Data
public class JobDTO {
    private Long job_id;
    private String jobTitle;
    private Long employer_id;
    private String description;
    private String required_Skills;
    private String jobStatus;
    private String skill_id;
}
