package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Applicant;
import com.example.Job.Board.app.repo.ApplicantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant registerApplicant(Applicant applicant) {
        log.info("saving new applicant {} to the database",applicant.getApplicant_id());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return applicantRepository.save(applicant);
    }

}
