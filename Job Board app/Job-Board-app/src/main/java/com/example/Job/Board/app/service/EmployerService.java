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
            employer.setEmployerId(detail.getEmployerId());
            employer.setCompanyName(detail.getCompanyName());
            employer.setEmail(detail.getEmail());
            employer.setAddress(detail.getAddress());
            employer.setCity(detail.getCity());
            employer.setState(detail.getState());
            employer.setWebsite(detail.getWebsite());
            employer.setMobileNo(detail.getMobileNo());
            employer.setUserId(detail.getUserId());
            employerDTOS.add(employer);
        });
        return employerDTOS;

    }

    public Optional<Employer> addNewEmployer(EmployerDTO detail) {
        Employer employer =new Employer();
        employer.setEmployerId(detail.getEmployerId());
        employer.setCompanyName(detail.getCompanyName());
        employer.setEmail(detail.getEmail());
        employer.setAddress(detail.getAddress());
        employer.setCity(detail.getCity());
        employer.setState(detail.getState());
        employer.setWebsite(detail.getWebsite());
        employer.setMobileNo(detail.getMobileNo());
        employer.setUserId(detail.getUserId());
        Optional<Employer> employerOptional= employerRepository.findById(employer.getEmployerId());
        if (employerOptional.isPresent()){
            throw new IllegalMonitorStateException("employer id is existing ");
        }
        employerRepository.save(employer);
        return employerOptional;
    }
    public Optional<Employer> getEmployer(Long Id){
        return employerRepository.findById(Id);
    }
    public void deleteEmployer(Long employerId) {
        boolean exists= employerRepository.existsById(employerId);
        if(! exists){throw new IllegalStateException("employer with id " + employerId +"does not exists");
        }
        employerRepository.deleteById(employerId);
    }

    public List<Jobs> getJobPostEmployer(Long employerId) {
        return employerRepository.findByjobId(employerId);
    }

    public JobApplicantRepository hireApplicant(JobApplicantDTO detail) {
        JobApplicant jobApplicant = new JobApplicant();
        jobApplicant.setId(detail.getId());

        jobApplicant.setStatus(detail.getStatus());
        jobApplicantRepository.save(jobApplicant);
        return jobApplicantRepository;

    }

}

