package com.example.jobseekerapp.repository;

import com.example.jobseekerapp.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(new Client("Peter", "asddasdasd@tasdasdasdest.com"));
    }
}
