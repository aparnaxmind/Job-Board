package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.repo.ApplicantRepository;
import com.example.Job.Board.app.repo.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class EmployerService {
    private final EmployerRepository employerRepository;
    private Object status;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer registerEmployer(Employer employer) {
        log.info("saving new employer {} to the database",employer.getCompany_name());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return employerRepository.save(employer);
    }

    public void deleteEmployer(Long employer_id){
        boolean exists= employerRepository.existsById(employer_id);
        if(! exists){throw new IllegalStateException("employer with id " + employer_id +"does not exists");
        }
        employerRepository.deleteById(employer_id);
    }

    public Jobs getJobPostEmployer(Long employer_id) {
        log.info("fetching all jobs posted by employer_id {}",employer_id);
        return employerRepository.findByjob_id(employer_id);
    }

    @Transactional
    public void hireApplicant(Long applicant_id){
        Applicant applicant = ApplicantRepository.findByapplicant_id(applicant_id);
        if(applicant==null)
            throw new IllegalMonitorStateException("applicant with id " + applicant_id +"does not exists");
        status = "selected";
        }
    }

