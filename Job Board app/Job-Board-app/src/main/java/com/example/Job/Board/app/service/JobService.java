package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JobService {


    private static JobsRepository jobsRepository;

    public Jobs createJobs(Jobs jobs) {
        log.info("saving new jobs {} to the database",jobs.getJob_id());
        //employer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return jobsRepository.save(jobs);
    }


//    public static Jobs searchJob(Long job_id) {
//        log.info("fetching Jobs {}",job_id);
//        return JobsRepository.findByjob_id(job_id);
//    }


    public static List<Jobs> getJobs(JobDTO jobDTO) {
        log.info("fetching Jobs ");
        return jobsRepository.findAll();
    }

    public static void deleteJob(Long job_id){
        boolean exists= jobsRepository.existsById(job_id);
            if(! exists){throw new IllegalStateException("jobs with id " + job_id +"does not exists");
            }
            jobsRepository.deleteById(job_id);
        }


//    public Jobs findByjob_id(Long job_id) {
//        return Jobs;
    }

