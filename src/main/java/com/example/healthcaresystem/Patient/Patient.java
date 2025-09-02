package com.example.healthcaresystem.Patient;

import com.example.healthcaresystem.MedicalRecord.MedicalRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate IDs

    private long id;
    private String firstName;
    private String secondName;

}
