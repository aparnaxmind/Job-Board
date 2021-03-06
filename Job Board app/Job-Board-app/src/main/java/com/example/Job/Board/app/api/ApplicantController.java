package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.ApplicantDTO;
import com.example.Job.Board.app.dtos.EmployerDTO;
import com.example.Job.Board.app.dtos.JobApplicantDTO;
import com.example.Job.Board.app.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping(path="api/v1/applicant")

public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping("/applicant")
    public List<ApplicantDTO>  getApplicant(){
        List<ApplicantDTO> applicantList=applicantService. getApplicant();
        if(applicantList.isEmpty())
            throw new IllegalMonitorStateException("applicant list is empty");
        return applicantList;
    }

    @GetMapping("/applicant/{id}")
    public Optional<Applicant> getApplicant(@PathVariable long id) {
        Optional<Applicant> applicantDTO;
        applicantDTO=applicantService.getApplicant(id);
        return applicantDTO;
    }
    @PostMapping("/applicant/save")
    public void addNewApplicant(@RequestBody ApplicantDTO applicantDTO){
        applicantService.addNewApplicant(applicantDTO);
    }
    @DeleteMapping(path = "{applicant_id}")
    public void deleteApplicant(@PathVariable("applicant_id")Long applicant_id){
        applicantService.deleteApplicant(applicant_id);
    }
    @PostMapping("/applicant/apply")
    public void apply(@PathVariable("job_id")Long job_id, @RequestBody JobApplicantDTO jobapplicantDTO){
        applicantService.apply( jobapplicantDTO);
    }
    @PostMapping("/applicant/job/{id}")
    public void getApplicantByJobId(@PathVariable("job_id")Long job_id){
        applicantService.getApplicantByJobId(job_id);
    }

    @PostMapping("/applicant/search")
    public void searchJobWithSkill(@PathVariable("skill_id")Long skill_id){
        applicantService.searchJobWithSkill(skill_id);
    }

}
