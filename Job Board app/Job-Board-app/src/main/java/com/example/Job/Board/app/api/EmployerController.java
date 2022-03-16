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
    @GetMapping("/employer")
    public List<EmployerDTO> getEmployer(){
        List<EmployerDTO> employerList=employerService.getEmployer();
        if(employerList.isEmpty())
            throw new IllegalMonitorStateException("Employer list is empty");
        return employerList;
    }

    @GetMapping("/employer/{id}")
    public Optional<Employer> getEmployer(@PathVariable long Id) {
        Optional<Employer> employerDTO;
        employerDTO=employerService.getEmployer(Id);
        return employerDTO;
    }
    @PostMapping("/employer/save")
    public void addNewEmployer(@RequestBody EmployerDTO employerDTO){
        employerService.addNewEmployer(employerDTO);
    }
    @DeleteMapping(path = "{employerId}")
    public void deleteEmployer(@PathVariable("employerId")Long employerId){
        employerService.deleteEmployer(employerId);
    }

    @GetMapping("/employer/{id}")
    public List<Jobs> getJobPostEmployer(@PathVariable long Id) {
        List<Jobs> employerDTO;
        employerDTO=employerService.getJobPostEmployer(Id);
        return employerDTO;
    }

    @PostMapping
    public void hireApplicant(@PathVariable("applicantId")Long applicantId){
        employerService.hireApplicant(new JobApplicantDTO());
    }
}
