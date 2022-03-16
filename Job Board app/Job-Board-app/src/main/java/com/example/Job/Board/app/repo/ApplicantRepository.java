package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    Optional<Applicant> findById(Long applicantId);

    Optional<Applicant> findApplicantByEmail(String email);
}
