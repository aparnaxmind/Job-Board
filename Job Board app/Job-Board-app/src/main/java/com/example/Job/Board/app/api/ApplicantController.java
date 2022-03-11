package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.dtos.ApplicantDTO;
import com.example.Job.Board.app.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public void registerApplicant(@RequestBody Applicant applicant){
        applicantService.registerApplicant(applicant);
    }
    @PostMapping
    public void apply(@PathVariable("job_id")Long job_id){
        applicantService.apply(job_id);
    }
}