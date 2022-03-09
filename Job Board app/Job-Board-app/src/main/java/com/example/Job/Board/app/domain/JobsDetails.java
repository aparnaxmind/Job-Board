package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JobsDetails {
   private Long job_id;
   private String JobTitle;
   private Long employer_id;
   private String Description;
   private String required_Skills;
   private String JobStatus;
   private String skillid;
}
