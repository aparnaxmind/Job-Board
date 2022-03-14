package com.example.Job.Board.app.repo;

import com.example.Job.Board.app.domain.Jobs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
    static Jobs findByjob_id(Long job_id) {
        return findByjob_id(job_id);
    }
    Optional<Jobs> findTeacherByEmail(String email);
    static Jobs findByskill_id(Long skill_id) {
        return findByskill_id(skill_id);
    }
}
