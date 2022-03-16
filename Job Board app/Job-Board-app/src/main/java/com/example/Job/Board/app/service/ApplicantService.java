package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.JobApplicant;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.ApplicantDTO;
import com.example.Job.Board.app.dtos.JobApplicantDTO;
import com.example.Job.Board.app.repo.ApplicantRepository;
import com.example.Job.Board.app.repo.JobApplicantRepository;
import com.example.Job.Board.app.repo.JobsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final JobsRepository jobsRepository;
    private final JobApplicantRepository jobApplicantRepository;
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository, JobsRepository jobsRepository, JobApplicantRepository jobApplicantRepository) {
        this.applicantRepository = applicantRepository;
        this.jobsRepository = jobsRepository;
        this.jobApplicantRepository = jobApplicantRepository;
    }

    public List<ApplicantDTO> getApplicant(){
        List<Applicant> listOfApplicant=applicantRepository.findAll();
        List<ApplicantDTO> applicantDTOS=new ArrayList<>();
        listOfApplicant.forEach(detail->{
            ApplicantDTO applicant =new ApplicantDTO();
            applicant.setApplicant_id(detail.getApplicant_id());
            applicant.setFirstName(detail.getFirstName());
            applicant.setLastName(detail.getLastName());
            applicant.setEmail(detail.getEmail());
            applicant.setGender(detail.getGender());
            applicant.setDob(detail.getDob());
            applicant.setSkills(detail.getSkills());
            applicant.setUser_id(detail.getUser_id());
            applicantDTOS.add(applicant);
        });
        return applicantDTOS;

    }

    public Optional<Applicant> addNewApplicant(ApplicantDTO detail) {
        Applicant applicant =new Applicant();
        applicant.setApplicant_id(detail.getApplicant_id());
        applicant.setFirstName(detail.getFirstName());
        applicant.setLastName(detail.getLastName());
        applicant.setEmail(detail.getEmail());
        applicant.setGender(detail.getGender());
        applicant.setDob(detail.getDob());
        applicant.setSkills(detail.getSkills());
        applicant.setUser_id(detail.getUser_id());

        Optional<Applicant> applicantOptional= applicantRepository.findApplicantByEmail(applicant.getEmail());
        if (applicantOptional.isPresent()){
            throw new IllegalMonitorStateException("email taken");
        }
        applicantRepository.save(applicant);
        return applicantOptional;
    }

    public Optional<Applicant> getApplicant(Long id){
        return applicantRepository.findByApplicant_id(id);
    }
    public void deleteApplicant(Long applicant_id) {
        boolean exists= applicantRepository.existsById(applicant_id);
        if(! exists){throw new IllegalStateException("Applicant with id " + applicant_id +"does not exists");
        }
        applicantRepository.deleteById(applicant_id);
    }

    public JobApplicantRepository apply(JobApplicantDTO detail) {
        JobApplicant jobapplicant = new JobApplicant();
        jobapplicant.setId(detail.getId());
        jobapplicant.setApplicant_id(detail.getApplicant_id());
        jobapplicant.setJob_id(detail.getJob_id());
        jobapplicant.setStatus(detail.getStatus());

        jobApplicantRepository.save(jobapplicant);
        return jobApplicantRepository;
    }
    public Optional<Jobs> getApplicantByJobId(Long job_id) {
        return jobsRepository.findByJob_id(job_id);
    }

    public  Optional<Jobs> searchJobWithSkill(Long skill_id) {
        return jobsRepository.findBySkill_id(skill_id);
    }
}
