package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Employer findByemployer_id(Long employer_id);
}
