package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    Optional<Applicant> findByApplicant_id(Long applicant_id);

    Optional<Applicant> findApplicantByEmail(String email);
}
