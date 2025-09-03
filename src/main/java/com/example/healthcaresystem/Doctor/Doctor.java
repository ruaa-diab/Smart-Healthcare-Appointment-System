package com.example.healthcaresystem.Doctor;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.*;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate IDs
    private long doctorId;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;
    @Column(nullable=false)
    private Speciality speciality;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id") // Foreign key in timeslot table
    private Set<DoctorTimeSlot> timeSlots;

    public Doctor() {
        this.timeSlots= new HashSet<>();

    }

    public Doctor(String firstName, String lastName, Speciality speciality) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.timeSlots =new HashSet<>();
    }

    public Doctor(long doctorId, String firstName, String lastName, Speciality speciality) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.timeSlots = new HashSet<>();
    }


    public boolean getAvailableSlot(WeekDays day, LocalTime time) {
        // Check weekends
        if(day == WeekDays.FRIDAY || day == WeekDays.SATURDAY) {
            return false;
        }

        // Check hours
        if(time.isAfter(LocalTime.of(17,0)) || time.isBefore(LocalTime.of(9,0))) {
            return false;
        }

        // Check minutes
        if(time.getMinute() != 0 && time.getMinute() != 30) {
            return false;
        }

        // Check if slot exists
        return this.timeSlots.stream()
                .anyMatch(slot -> slot.getDayOfWeek() == day && slot.getAvailableTime().equals(time));
    }
}
