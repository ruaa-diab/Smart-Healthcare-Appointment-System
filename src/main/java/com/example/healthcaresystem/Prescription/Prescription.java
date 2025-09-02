package com.example.healthcaresystem.Prescription;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "prescription")
public class Prescription {

    private String id;
    private List<String>meds;
    private long patientId;
    private long doctorId;

    public Prescription() {
        this.meds=new ArrayList<>();
    }


    public Prescription(List<String> meds, long patientId, long doctorId) {
        this.meds = new ArrayList<>();
        this.patientId = patientId;
        this.doctorId = doctorId;
    }
    public Prescription(String id, List<String> meds, long patientId, long doctorId) {
        this.id = id;
        this.meds =new ArrayList<>();
        this.patientId = patientId;
        this.doctorId = doctorId;
    }
}
