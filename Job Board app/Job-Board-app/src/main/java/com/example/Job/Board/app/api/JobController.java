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

    @GetMapping("/job/{id}")
    public Optional<Jobs> getJobs(@PathVariable long id) {
        Optional<Jobs> jobDTO;
        jobDTO=jobService.getJobs(id);
        return jobDTO;
    }
    @PostMapping
    public void addNewJobs(@RequestBody JobDTO jobDTO){
        jobService.addNewJobs(jobDTO);
    }
    @DeleteMapping(path = "{job_id}")
    public void deleteJobs(@PathVariable("job_id")Long job_id){
        jobService.deleteJobs(job_id);
    }
    @GetMapping("/jobs/{id}")
    public Optional<Jobs> searchJob(@PathVariable long job_id) {
        Optional<Jobs> jobDTO;
        jobDTO=JobService.searchJob(job_id);
        return jobDTO;
    }

}
