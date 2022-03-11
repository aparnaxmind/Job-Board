package com.example.Job.Board.app.api;

import com.example.Job.Board.app.domain.Jobs;
import com.example.Job.Board.app.dtos.JobDTO;
import com.example.Job.Board.app.repo.JobsRepository;
import com.example.Job.Board.app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/jobs")
public class JobController {
    @Autowired
    private JobsRepository jobsRepository;

    @PostMapping
    public void getJobs(@RequestBody JobDTO jobDTO){
        JobService.getJobs(jobDTO);
    }
    @PostMapping
    public void createJobs(@RequestBody JobDTO jobDTO) {
        JobService.getJobs(jobDTO);
    }
    @DeleteMapping(path = "{job_id}")
    public void deleteJob(@PathVariable("job_id")Long job_id){
        JobService.deleteJob(job_id);
    }
    public Jobs searchJob(Long job_id) {
        return JobsRepository.findByjob_id(job_id);
    }
    @GetMapping("/jobs/{id}")
    public Jobs searchJob(@PathVariable long job_id) {
        Jobs jobDTO;
        jobDTO=JobService.searchJob(job_id);
        return jobDTO;
    }
}
