package com.example.Job.Board.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Jobs {
   @Id
   @GeneratedValue(strategy = AUTO)

   private Long jobId;
   private String jobTitle;
   private String description;
   private String jobStatus;

//   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//   @JoinColumn(name ="employer_id",referencedColumnName = "employer_id")
//   private Employer employerDetails;

   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name ="employerId",referencedColumnName = "employerId")
   private Employer employer;

   @OneToMany(cascade = CascadeType.ALL,mappedBy = "jobs")
   private Set<JobApplicant> jobApplicant;

   @ManyToMany
   @JoinTable(name = "jobSkills ",
           joinColumns = {
                   @JoinColumn(name = "jobId", referencedColumnName = "jobId",
                           nullable = false, updatable = false)},
           inverseJoinColumns = {
                   @JoinColumn(name = "skillId", referencedColumnName = "skillId",
                           nullable = false, updatable = false)})
   private Set<Skills> skills;




   @Override
   public String toString() {
      return "Jobs [job_id = " + jobId + ", jobTitle = " +jobTitle +   ", description = " + description
              + ",jobStatus = " +jobStatus +  "]";
   }
}
