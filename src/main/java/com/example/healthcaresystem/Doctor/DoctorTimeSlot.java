package com.example.healthcaresystem.Doctor;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "doctor_time_slots")
public class DoctorTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private WeekDays dayOfWeek;
    private LocalTime availableTime;


    public DoctorTimeSlot() {
    }

    public DoctorTimeSlot(  WeekDays dayOfWeek, LocalTime availableTime) {

        this.dayOfWeek = dayOfWeek;
        this.availableTime = availableTime;
    }
}
