package com.example.jobseekerapp.repository;

import com.example.jobseekerapp.entity.Client;
import com.example.jobseekerapp.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(new Client("Peter", "peter@testdomain.com"));
        jobRepository.save(new Job("Java developer", "Debrecen"));
    }
}
