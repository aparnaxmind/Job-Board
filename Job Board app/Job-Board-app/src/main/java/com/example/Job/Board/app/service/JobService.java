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
            job.setJob_id(detail.getJob_id());
            job.setJobTitle(detail.getJobTitle());

            job.setDescription(detail.getDescription());
            job.setRequired_Skills(detail.getRequired_Skills());
            job.setJobStatus(detail.getJobStatus());
            job.setSkill_id(detail.getSkill_id());
            JobsDTOS.add(job);
        });
        return JobsDTOS;

    }

    public Optional<Jobs> addNewJobs(JobDTO detail) {
        Jobs job =new Jobs();
        job.setJob_id(detail.getJob_id());
        job.setJobTitle(detail.getJobTitle());

        job.setDescription(detail.getDescription());
        job.setRequired_Skills(detail.getRequired_Skills());
        job.setJobStatus(detail.getJobStatus());
        job.setSkill_id(detail.getSkill_id());

        Optional<Jobs> jobsOptional= jobsRepository.findByJob_id(detail.getJob_id());
        if (jobsOptional.isPresent()){
            throw new IllegalMonitorStateException("job is already exist");
        }
        jobsRepository.save(job);
        return jobsOptional;
    }
    public Optional<Jobs> getJobs(Long id){
        return jobsRepository.findById(id);
    }
    public void deleteJobs(Long job_id) {
        boolean exists= jobsRepository.existsById(job_id);
        if(! exists){throw new IllegalStateException("Jobs with id " + job_id +"does not exists");
        }
        jobsRepository.deleteById(job_id);
    }

    public Optional<Jobs> searchJob(Long job_id) {
        return jobsRepository.findByJob_id(job_id);
    }
    }


