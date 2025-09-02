package com.example.healthcaresystem.Admin;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate IDs

    private Long id;

    private String firstName;
    private String lastName;


    public Admin() {
    }

    public Admin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Admin(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
