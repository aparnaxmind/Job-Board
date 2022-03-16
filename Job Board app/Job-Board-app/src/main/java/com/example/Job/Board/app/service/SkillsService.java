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
            skl.setSkillId(detail.getSkillId());
            skl.setSkillName(detail.getSkillName());
            skillsDTOS.add(skl);
        });
        return skillsDTOS;
    }

    public void addNewSkills(SkillsDTO skillsDetails) {

        Skills skills = new Skills();
        skills.setSkillId(skillsDetails.getSkillId());
        skills.setSkillName(skillsDetails.getSkillName());
        skillsRepository.save(skills);

    }

    public void deleteSkills(Long skillId) {
        boolean exists = skillsRepository.existsById(skillId);
        if (!exists) {
            throw new IllegalStateException("skills with id " + skillId + "does not exists");
        }
        skillsRepository.deleteById(skillId);
    }

}
