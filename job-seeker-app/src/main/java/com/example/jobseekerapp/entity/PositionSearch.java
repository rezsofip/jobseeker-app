package com.example.jobseekerapp.entity;


import jakarta.validation.constraints.Size;


public class PositionSearch {


    private String name;
    @Size(max = 50, message = "The location is too long!")
    private String location;

    public PositionSearch() {

    }

    public PositionSearch(String keyword, String location) {
        this.name = keyword;
        this.location = location;
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
