package com.example.healthcaresystem.Appointment;

import com.example.healthcaresystem.Doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    // In AppointmentRepository, use:
    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(
            Doctor doctor, LocalDate date, LocalTime time);}
