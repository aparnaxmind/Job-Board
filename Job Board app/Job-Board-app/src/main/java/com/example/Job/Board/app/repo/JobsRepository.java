package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
    Optional<Jobs> findByJob_id(Long job_id) ;
    Optional<Jobs> findBySkill_id(Long skill_id);

}
