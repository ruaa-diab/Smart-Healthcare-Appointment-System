package com.example.healthcaresystem;

import com.example.healthcaresystem.MedicalRecord.MedicalRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EntityScan(basePackages = {
        "com.example.healthcaresystem.Admin",
        "com.example.healthcaresystem.Appointment",
        "com.example.healthcaresystem.Doctor",
        "com.example.healthcaresystem.Patient"
})
@EnableJpaRepositories(basePackages = {
        "com.example.healthcaresystem.Admin",
        "com.example.healthcaresystem.Appointment",
        "com.example.healthcaresystem.Doctor",
        "com.example.healthcaresystem.Patient"
})
@EnableMongoRepositories(basePackages = {
        "com.example.healthcaresystem.MedicalRecord",
        "com.example.healthcaresystem.Prescription"
})


public class HealthcareSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareSystemApplication.class, args);

        MedicalRecord medicalRecord=new MedicalRecord();
        System.out.println(medicalRecord.getLabResults().size());
        System.out.println(medicalRecord.getNotes().size());
        System.out.println(medicalRecord.getPrescriptions().size());


    }

}
