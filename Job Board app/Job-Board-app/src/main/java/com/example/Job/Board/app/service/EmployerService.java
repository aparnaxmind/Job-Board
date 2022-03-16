package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Employer;
import com.example.Job.Board.app.domain.JobApplicant;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.EmployerDTO;
import com.example.Job.Board.app.dtos.JobApplicantDTO;
import com.example.Job.Board.app.repo.EmployerRepository;
import com.example.Job.Board.app.repo.JobApplicantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final JobApplicantRepository jobApplicantRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository, JobApplicantRepository jobApplicantRepository) {
        this.employerRepository = employerRepository;
        this.jobApplicantRepository = jobApplicantRepository;
    }

    public List<EmployerDTO> getEmployer(){

        List<Employer> listOfEmployer=employerRepository.findAll();
        List<EmployerDTO> employerDTOS=new ArrayList<>();
        listOfEmployer.forEach(detail->{
            EmployerDTO employer =new EmployerDTO();
            employer.setEmployer_id(detail.getEmployer_id());
            employer.setCompany_name(detail.getCompany_name());
            employer.setEmail(detail.getEmail());
            employer.setAddress(detail.getAddress());
            employer.setCity(detail.getCity());
            employer.setState(detail.getState());
            employer.setWebsite(detail.getWebsite());
            employer.setMobile_no(detail.getMobile_no());
            employer.setUser_id(detail.getUser_id());
            employerDTOS.add(employer);
        });
        return employerDTOS;

    }

    public Optional<Employer> addNewEmployer(EmployerDTO detail) {
        Employer employer =new Employer();
        employer.setEmployer_id(detail.getEmployer_id());
        employer.setCompany_name(detail.getCompany_name());
        employer.setEmail(detail.getEmail());
        employer.setAddress(detail.getAddress());
        employer.setCity(detail.getCity());
        employer.setState(detail.getState());
        employer.setWebsite(detail.getWebsite());
        employer.setMobile_no(detail.getMobile_no());
        employer.setUser_id(detail.getUser_id());
        Optional<Employer> employerOptional= employerRepository.findByEmployer_id(employer.getEmployer_id());
        if (employerOptional.isPresent()){
            throw new IllegalMonitorStateException("employer id is existing ");
        }
        employerRepository.save(employer);
        return employerOptional;
    }
    public Optional<Employer> getEmployer(Long id){
        return employerRepository.findById(id);
    }
    public void deleteEmployer(Long employer_id) {
        boolean exists= employerRepository.existsById(employer_id);
        if(! exists){throw new IllegalStateException("employer with id " + employer_id +"does not exists");
        }
        employerRepository.deleteById(employer_id);
    }

    public Optional<Jobs> getJobPostEmployer(Long employer_id) {
        return employerRepository.findByjob_id(employer_id);
    }

    public JobApplicantRepository hireApplicant(JobApplicantDTO detail) {
        JobApplicant jobApplicant = new JobApplicant();
        jobApplicant.setId(detail.getId());
        jobApplicant.setJob_id(detail.getJob_id());
        jobApplicant.setApplicant_id(detail.getApplicant_id());
        jobApplicant.setStatus(detail.getStatus());
        jobApplicantRepository.save(jobApplicant);
        return jobApplicantRepository;

    }

}

