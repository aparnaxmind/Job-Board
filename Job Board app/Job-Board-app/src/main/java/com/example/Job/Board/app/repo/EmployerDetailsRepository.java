package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.EmployerDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDetailsRepository extends JpaRepository<EmployerDetails,Long> {
    EmployerDetails findByemployer_id(Long employer_id);
}
