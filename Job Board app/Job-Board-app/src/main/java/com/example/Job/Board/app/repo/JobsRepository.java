package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
    static Jobs findByjob_id(Long job_id) {
        return null;
    }
}
