package com.example.healthcaresystem.MedicalRecord;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord,String> {
}
