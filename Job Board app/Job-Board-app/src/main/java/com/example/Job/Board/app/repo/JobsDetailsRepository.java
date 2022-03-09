package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.JobsDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsDetailsRepository extends JpaRepository<JobsDetails,Long> {
    JobsDetails findByjob_id(Long job_id);
}
