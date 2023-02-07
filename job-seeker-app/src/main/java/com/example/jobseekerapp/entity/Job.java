package com.example.jobseekerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Entity(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private int id;

    @Size(max = 100)
    private String name;
    @Size(max = 50)
    private String location;

    public Job() {

    }

    public Job(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
