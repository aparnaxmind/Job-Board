package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/employer")
public class EmployerController {
    private final EmployerService employerService;
    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/employerjobs")
    public ResponseEntity<Jobs> getJobPostEmployer(Long employer_id) {

        return ResponseEntity.ok().body(employerService.getJobPostEmployer(employer_id));
    }

    @PostMapping
    public void registerEmployer(@RequestBody Employer employer){
        employerService.registerEmployer(employer);
    }
    @DeleteMapping(path = "{employer_id}")
    public void deleteEmployer(@PathVariable("employer_id")Long employer_id){
        employerService.deleteEmployer(employer_id);
    }
    @PostMapping
    public void hireApplicant(@PathVariable("applicant_id")Long applicant_id){
        employerService.hireApplicant(applicant_id);
    }
}
