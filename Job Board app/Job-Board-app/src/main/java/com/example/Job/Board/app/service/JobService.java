package com.example.Job.Board.app.service;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JobService {


    public  JobsRepository jobsRepository;

    public List<JobDTO> getJobs(){

        List<Jobs> listOfJobs=jobsRepository.findAll();
        List<JobDTO> JobsDTOS=new ArrayList<>();
        listOfJobs.forEach(detail->{
            JobDTO job =new JobDTO();
            job.setJobId(detail.getJobId());
            job.setJobTitle(detail.getJobTitle());

            job.setDescription(detail.getDescription());

            job.setJobStatus(detail.getJobStatus());

            JobsDTOS.add(job);
        });
        return JobsDTOS;

    }

    public Optional<Jobs> addNewJobs(JobDTO detail) {
        Jobs job =new Jobs();
        job.setJobId(detail.getJobId());
        job.setJobTitle(detail.getJobTitle());

        job.setDescription(detail.getDescription());

        job.setJobStatus(detail.getJobStatus());

        Optional<Jobs> jobsOptional= jobsRepository.findById(detail.getJobId());
        if (jobsOptional.isPresent()){
            throw new IllegalMonitorStateException("job is already exist");
        }
        jobsRepository.save(job);
        return jobsOptional;
    }
    public Optional<Jobs> getJobs(Long Id){
        return jobsRepository.findById(Id);
    }
    public void deleteJobs(Long jobId) {
        boolean exists= jobsRepository.existsById(jobId);
        if(! exists){throw new IllegalStateException("Jobs with id " + jobId +"does not exists");
        }
        jobsRepository.deleteById(jobId);
    }

    public Optional<Jobs> searchJob(Long jobId) {
        return jobsRepository.findById(jobId);
    }
    }


