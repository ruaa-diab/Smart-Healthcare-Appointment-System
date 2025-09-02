package com.example.healthcaresystem.MedicalRecord;

import com.example.healthcaresystem.Prescription.Prescription;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "medical_records")
public class MedicalRecord {

    private String id;
    private long patientId;
    private Map<String,String> notes;//in the first string we want to record the doctor who put the note/date
    private Map<String,String> labResults;//here we store what kind these results are/actual results.
    private List<Prescription> prescriptions;


    //we need to initialize  so i won't have nullPointerException.
    public MedicalRecord() {
        notes=new HashMap<>();
        labResults=new HashMap<>();
        this.prescriptions=new ArrayList<>();

    }


}
