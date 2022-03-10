package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    Applicant findByapplicant_id(Long applicant_id);
}
