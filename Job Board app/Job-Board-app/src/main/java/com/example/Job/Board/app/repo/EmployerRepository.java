package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Employer;

import com.example.Job.Board.app.domain.Jobs;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Employer findByemployer_id(Long employer_id);

    Jobs findByjob_id(Long employer_id);


}
