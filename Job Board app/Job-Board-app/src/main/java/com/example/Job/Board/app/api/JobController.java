package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.repo.JobsRepository;
import com.example.Job.Board.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/jobs")
public class JobController {
    @Autowired
    private JobsRepository jobsRepository;
    private JobService jobService;

    @GetMapping
    public List<JobDTO> getJobs(){
        List<JobDTO> jobList=jobService.getJobs();
        if(jobList.isEmpty())
            throw new IllegalMonitorStateException("Job list is empty");
        return jobList;
    }

    @GetMapping("/job/{Id}")
    public Optional<Jobs> getJobs(@PathVariable long Id) {
        Optional<Jobs> jobDTO;
        jobDTO=jobService.getJobs(Id);
        return jobDTO;
    }
    @PostMapping
    public void addNewJobs(@RequestBody JobDTO jobDTO){
        jobService.addNewJobs(jobDTO);
    }
    @DeleteMapping(path = "{jobId}")
    public void deleteJobs(@PathVariable("jobId")Long jobId){
        jobService.deleteJobs(jobId);
    }
    @GetMapping("/jobs/{Id}")
    public Optional<Jobs> searchJob(@PathVariable long jobId) {
        Optional<Jobs> jobDTO;
        jobDTO=jobService.searchJob(jobId);
        return jobDTO;
    }

}
