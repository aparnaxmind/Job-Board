package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JobApplicantRepository  extends JpaRepository<JobApplicant,Long> {
    Optional<JobApplicant> findByApplicant_applicantId (Long applicantId);
    Optional<JobApplicant> findByJobs_jobId(Long jobId);
}
