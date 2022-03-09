package com.example.Job.Board.app.repo;


import com.example.Job.Board.app.domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills,Long> {
   Skills findByskill_id(Long skill_id);
}
