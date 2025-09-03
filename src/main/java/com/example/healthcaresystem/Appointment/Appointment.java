package com.example.healthcaresystem.Appointment;

import com.example.healthcaresystem.Doctor.Doctor;
import com.example.healthcaresystem.Patient.Patient;
import jakarta.persistence.*;
import lombok.Data;

import javax.security.auth.callback.LanguageCallback;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private boolean isCompleted=false;
    @Column(nullable = false)
    private LocalDate appointmentDate;
    @Column(nullable = false)
    private LocalTime appointmentTime;
    //we need to store the date and tim of the appointment.


    public Appointment() {
    }

    public Appointment(Long id, Doctor doctor, Patient patient, boolean isCompleted, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
    public Appointment( Doctor doctor, Patient patient, boolean isCompleted, LocalDate appointmentDate, LocalTime appointmentTime) {

        this.doctor = doctor;
        this.patient = patient;
        this.isCompleted = isCompleted;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
}
