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

   private Long job_id;
   private String jobTitle;
   private Long employer_id;
   private String description;
   private String required_Skills;
   private String jobStatus;
   private String skill_id;

   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name ="employer_id",referencedColumnName = "employer_id")
   private Employer employerDetails;

   @ManyToMany
   @JoinTable(name = "skills",
           joinColumns = {
                   @JoinColumn(name = "job_id", referencedColumnName = "job_id",
                           nullable = false, updatable = false)},
           inverseJoinColumns = {
                   @JoinColumn(name = "skill_id", referencedColumnName = "skill_id",
                           nullable = false, updatable = false)})
   private Set<Skills> skills;


   @Override
   public String toString() {
      return "Jobs [job_id = " + job_id + ", jobTitle = " +jobTitle + ", employer_id = " + employer_id + ", description = " + description
              + ", required_Skills = " + required_Skills + ", skill_id = " + skill_id+ ",jobStatus = " +jobStatus +  "]";
   }
}
