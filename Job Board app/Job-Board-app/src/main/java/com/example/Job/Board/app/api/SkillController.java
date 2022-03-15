package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.dtos.SkillsDTO;
import com.example.Job.Board.app.repo.JobsRepository;
import com.example.Job.Board.app.repo.SkillsRepository;
import com.example.Job.Board.app.service.JobService;
import com.example.Job.Board.app.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class SkillController {
    @Autowired
    private SkillsRepository skillsRepository;
    private SkillsService skillsService;

    @GetMapping
    public List<SkillsDTO> getSkill(){
        List<SkillsDTO> skillsList=skillsService.getSkill();
        if(skillsList.isEmpty())
            throw new IllegalMonitorStateException("skills list is empty");
        return skillsList;
    }
    @PostMapping
    public void addNewSkills(@RequestBody SkillsDTO skillsDTO){
        skillsService.addNewSkills(skillsDTO);
    }
    @DeleteMapping(path = "{skill_id}")
    public void deleteSkills(@PathVariable("skill_id")Long skill_id){
        skillsService.deleteSkills(skill_id);
    }


}
