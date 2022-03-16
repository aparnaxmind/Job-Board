package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobApplicantRepository  extends JpaRepository<JobApplicant,Long> {
    Optional<JobApplicant> findByApplicant_id(Long applicant_id);
    Optional<JobApplicant> findByJob_id(Long job_id);
}
