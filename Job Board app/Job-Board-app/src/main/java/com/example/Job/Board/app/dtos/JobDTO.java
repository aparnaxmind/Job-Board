package com.example.Job.Board.app.dtos;

import lombok.Data;

@Data
public class JobDTO {
    private Long jobId;
    private String jobTitle;
    private String description;

    private String jobStatus;

}
