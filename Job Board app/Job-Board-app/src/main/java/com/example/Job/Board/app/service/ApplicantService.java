package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.ApplicantDTO;
import com.example.Job.Board.app.repo.ApplicantRepository;
import com.example.Job.Board.app.repo.JobsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private String status;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant registerApplicant(Applicant applicant) {
        log.info("saving new applicant {} to the database",applicant.getApplicant_id());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return applicantRepository.save(applicant);
    }
//
//    public void apply(Long job_id){
//        Jobs jobs= JobsRepository. findByjob_id(job_id);
//        if(jobs==null)
//            throw new IllegalMonitorStateException("job with id " + job_id +"does not exists");
//        status = "apply";
//    }
//
//    public Applicant getApplicant(Long job_id) {
//        log.info("fetching all applicant of job_id {}",job_id);
//        return ApplicantRepository.findByjob_id(job_id);
//    }

//    public static Jobs searchJobWithSkill(Long skill_id) {
//        log.info("fetching Jobs with skill_id {}",skill_id);
//        return JobsRepository.findByskill_id(skill_id);
//    }

}
