package com.example.jobseekerapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity(name = "clients")
public class Client {

    @Column(name = "client_id")
    @Id
    @GeneratedValue
    private UUID clientId;

    @Size(max = 100, message = "The name is too long!")
    private String name;
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Not a valid email address!")
    private String email;

    public Client() {

    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UUID getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
