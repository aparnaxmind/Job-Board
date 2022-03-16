package com.example.Job.Board.app.repo;


import com.example.Job.Board.app.domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillsRepository extends JpaRepository<Skills,Long> {


}
