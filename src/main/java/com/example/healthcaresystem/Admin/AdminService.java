package com.example.healthcaresystem.Admin;

import com.example.healthcaresystem.Doctor.Doctor;
import com.example.healthcaresystem.Doctor.DoctorRepository;
import com.example.healthcaresystem.Patient.PatientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class AdminService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AdminService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Doctor> getDoctors(){
        List<Doctor> doctors=this.doctorRepository.findAll();
        if(doctors.isEmpty()){
            throw new IllegalStateException("there are no doctors yet");
        }
        return doctors;

    }



//    public boolean addDoctor(Doctor doctor){
//        this.doctorRepository.save(doctor);
//
//    }



}
