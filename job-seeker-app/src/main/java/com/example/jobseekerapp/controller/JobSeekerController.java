package com.example.jobseekerapp.controller;

import com.example.jobseekerapp.entity.Client;
import com.example.jobseekerapp.entity.Job;
import com.example.jobseekerapp.repository.ClientRepository;
import com.example.jobseekerapp.repository.JobRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Validated
public class JobSeekerController {

    private ClientRepository clientRepository;
    private JobRepository jobRepository;

    public JobSeekerController(ClientRepository clientRepository, JobRepository jobRepository) {
        this.clientRepository = clientRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping("/client")
    @ResponseBody
    public UUID registerClient(@RequestBody Client client) {
        clientRepository.save(client);
        return client.getClientId();
    }

    @PostMapping("/position")
    @ResponseBody
    public String createPosition(@RequestBody @Valid Job job, @RequestHeader String requestHeader, HttpServletRequest request) {
        if(clientRepository.existsById(UUID.fromString(requestHeader))) {
            jobRepository.save(job);
            return request.getRequestURI() + "?id=" + job.getId();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/position/search")
    @ResponseBody
    public List<String> getPosition(@RequestParam @Size(max = 50, message = "The name is too long!") String name,
                                    @RequestParam @Size(max = 50, message = "The location is too long!") String location,
                                    @RequestHeader String requestHeader, HttpServletRequest request) {
        if(clientRepository.existsById(UUID.fromString(requestHeader))) {
            List<Job> foundJobs =  jobRepository.findJobByKeyword(name, location);
            return foundJobs.stream().map(job -> request.getRequestURI() + "?id=" +job.getId()).toList();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/position/{id}")
    @ResponseBody
    public Job getPosition(@PathVariable int id, @RequestHeader String requestHeader) {
        if(clientRepository.existsById(UUID.fromString(requestHeader))) {
            Optional<Job> foundJob = jobRepository.findById(id);
            return foundJob.orElse(null);

        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

}
