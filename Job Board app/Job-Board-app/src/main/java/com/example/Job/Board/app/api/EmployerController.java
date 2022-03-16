package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.EmployerDTO;
import com.example.Job.Board.app.dtos.JobApplicantDTO;
import com.example.Job.Board.app.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/employer")
public class EmployerController {
    private final EmployerService employerService;
    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }
    @GetMapping
    public List<EmployerDTO> getEmployer(){
        List<EmployerDTO> employerList=employerService.getEmployer();
        if(employerList.isEmpty())
            throw new IllegalMonitorStateException("Employer list is empty");
        return employerList;
    }

    @GetMapping("/employer/{id}")
    public Optional<Employer> getEmployer(@PathVariable long id) {
        Optional<Employer> employerDTO;
        employerDTO=employerService.getEmployer(id);
        return employerDTO;
    }
    @PostMapping
    public void addNewEmployer(@RequestBody EmployerDTO employerDTO){
        employerService.addNewEmployer(employerDTO);
    }
    @DeleteMapping(path = "{employer_id}")
    public void deleteEmployer(@PathVariable("employer_id")Long employer_id){
        employerService.deleteEmployer(employer_id);
    }

    @GetMapping("/employer/{id}")
    public Optional<Jobs> getJobPostEmployer(@PathVariable long id) {
        Optional<Jobs> employerDTO;
        employerDTO=employerService.getJobPostEmployer(id);
        return employerDTO;
    }

    @PostMapping
    public void hireApplicant(@PathVariable("applicant_id")Long applicant_id){
        employerService.hireApplicant(new JobApplicantDTO());
    }
}
