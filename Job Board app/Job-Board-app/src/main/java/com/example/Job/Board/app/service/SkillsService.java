package com.example.Job.Board.app.service;


import com.example.Job.Board.app.domain.Role;
import com.example.Job.Board.app.domain.Skills;
import com.example.Job.Board.app.dtos.RoleDTO;
import com.example.Job.Board.app.dtos.SkillsDTO;
import com.example.Job.Board.app.repo.RoleRepository;
import com.example.Job.Board.app.repo.SkillsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public List<SkillsDTO> getSkill() {

        List<Skills> listOfSkill = skillsRepository.findAll();
        List<SkillsDTO> skillsDTOS = new ArrayList<>();
        listOfSkill.forEach(detail -> {
            SkillsDTO skl = new SkillsDTO();
            skl.setSkill_id(detail.getSkill_id());
            skl.setSkill_name(detail.getSkill_name());
            skillsDTOS.add(skl);
        });
        return skillsDTOS;
    }

    public void addNewSkills(SkillsDTO skillsDetails) {

        Skills skills = new Skills();
        skills.setSkill_id(skillsDetails.getSkill_id());
        skills.setSkill_name(skillsDetails.getSkill_name());
        skillsRepository.save(skills);

    }

    public void deleteSkills(Long skill_id) {
        boolean exists = skillsRepository.existsById(skill_id);
        if (!exists) {
            throw new IllegalStateException("skills with id " + skill_id + "does not exists");
        }
        skillsRepository.deleteById(skill_id);
    }

}
