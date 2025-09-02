package com.example.healthcaresystem.Appointment;

import com.example.healthcaresystem.Doctor.Doctor;
import com.example.healthcaresystem.Patient.Patient;
import jakarta.persistence.*;
import lombok.Data;

import javax.security.auth.callback.LanguageCallback;
import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate IDs
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)//now i save id of doctor instead of doctor in db but i can retrive the object.
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient ;
    private boolean isCompleted;
    private LocalDateTime time;
    //we need to store the date and tim of the appointment.


    public Appointment() {
    }

    public Appointment( Doctor doctor, Patient patient, boolean isCompleted, LocalDateTime time) {

        this.doctor = doctor;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.time = time;
    }
    public Appointment(long id, Doctor doctor, Patient patient, boolean isCompleted, LocalDateTime time) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.time = time;
    }
}
