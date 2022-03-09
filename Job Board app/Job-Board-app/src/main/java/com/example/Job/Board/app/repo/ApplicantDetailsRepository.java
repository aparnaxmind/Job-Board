package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.ApplicantDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails,Long> {
    ApplicantDetails findByapplicant_id(Long applicant_id);
}
