package com.example.Job.Board.app.service;


import com.example.Job.Board.app.domain.Skills;
import com.example.Job.Board.app.repo.SkillsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public Skills saveSkills(Skills skills) {
        log.info("saving new skills {} to the database",skills.getSkill_id());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return skillsRepository.save(skills);
    }

}
