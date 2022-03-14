package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    static Applicant findByapplicant_id(Long applicant_id) {
        return findByapplicant_id(applicant_id);
    }
    static Applicant findByjob_id(Long job_id) {
            return findByjob_id(job_id);
        }
}
