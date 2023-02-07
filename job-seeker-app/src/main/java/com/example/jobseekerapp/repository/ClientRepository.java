package com.example.jobseekerapp.repository;

import com.example.jobseekerapp.entity.Client;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, UUID> {



}
