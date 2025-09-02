package com.example.healthcaresystem.Doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate IDs
    private long doctorId;
    private String firstName;
    private String lastName;
    private Speciality speciality;
    private Set<LocalTime> availableSlots;

    public Doctor() {
        this.availableSlots=new HashSet<>();
    }

    public Doctor(String firstName, String lastName, Speciality speciality, Set<LocalTime> availableSlots) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.availableSlots = new HashSet<>();
    }

    public Doctor(long doctorId, String firstName, String lastName, Speciality speciality, Set<LocalTime> availableSlots) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.availableSlots = new HashSet<>();
    }


    public boolean  getAvailableSlot(LocalTime time) {

        if(time.isAfter(LocalTime.of(17,0))|| time.isBefore(LocalTime.of(9,0))){
            return false;
        }
        if(!this.availableSlots.contains(time)){
            return false;
        }
        if(time.getMinute()!=0&&time.getMinute()!=30){
            return false;
        }
        return true;

    }
}
