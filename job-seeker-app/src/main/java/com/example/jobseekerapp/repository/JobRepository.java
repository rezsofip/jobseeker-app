package com.example.jobseekerapp.repository;

import com.example.jobseekerapp.entity.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface JobRepository extends JpaRepository<Job, String> {

    @Query("FROM jobs WHERE LOWER(name) LIKE CONCAT('%', LOWER(?1), '%') AND LOWER(location) LIKE CONCAT('%', LOWER(?2), '%')")
    List<Job> findJobByKeyword(String name, String location);

}
