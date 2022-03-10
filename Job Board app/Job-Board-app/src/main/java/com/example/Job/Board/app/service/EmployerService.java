package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.repo.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployerService {
    private final EmployerRepository employerRepository;
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
}
